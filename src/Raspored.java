import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Raspored {
    private List<Termin> termini;
    private List<Soba> sobe;

    public Raspored() {
        termini = new ArrayList<>();
        sobe = new ArrayList<>();
    }

    public void addSoba(Soba soba) {
        if (sobe.contains(soba)) {
            return;
        }
        sobe.add(soba);
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public void addTermin(Termin termin, boolean force) {
        Termin check = checkIfTerminIsAvailable(termin);
        if (force) {
            if (check != null) {
                removeTermin(check);
            }
        }

        if (check != null) {
            throw new IllegalArgumentException("Termin nije slobodan!");
        }

        termini.add(termin);
    }

    public void removeTermin(Termin termin) {
        termini.remove(termin);
    }

    public void moveTermin(Termin termin, LocalDateTime newStart, LocalDateTime newEnd) {

        removeTermin(termin);

        Termin check = checkIfTerminIsAvailable(new Termin(termin.getSoba(), termin.getProfesor(),termin.getTipPredavanja(), newStart, newEnd, termin.getGrupe(), termin.isReccuring()));
        if (check != null) {
            addTermin(termin, true);
            throw new IllegalArgumentException("Termin nije slobodan!");
        }

        termin.setPocetak(newStart);
        termin.setKraj(newEnd);
        addTermin(termin, false);
    }

    private Termin checkIfTerminIsAvailable(Termin termin) {
        for (Termin t : termini) {
            if (doTimesOverlap(termin.getPocetak(), termin.getKraj(), t.getPocetak(), t.getKraj())) {
                if (isSameRoomOrProfessor(termin, t)) {
                    return t;
                }
            }

            if (termin.isReccuring() || t.isReccuring()) {
                if (termin.getPocetak().getDayOfWeek() == t.getPocetak().getDayOfWeek() &&
                        doTimesOverlapR(termin.getPocetak(), termin.getKraj(), t.getPocetak(), t.getKraj())) {
                    if (isSameRoomOrProfessor(termin, t)) {
                        return t;
                    }
                }
            }
        }

        return null;
    }

    private boolean doTimesOverlapR(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        LocalTime timeStart1 = start1.toLocalTime().truncatedTo(ChronoUnit.MINUTES);
        LocalTime timeEnd1 = end1.toLocalTime().truncatedTo(ChronoUnit.MINUTES);
        LocalTime timeStart2 = start2.toLocalTime().truncatedTo(ChronoUnit.MINUTES);
        LocalTime timeEnd2 = end2.toLocalTime().truncatedTo(ChronoUnit.MINUTES);

        return (timeStart1.isAfter(timeStart2) && timeStart1.isBefore(timeEnd2)) ||
                (timeEnd1.isAfter(timeStart2) && timeEnd1.isBefore(timeEnd2)) ||
                (timeStart1.equals(timeStart2) || timeEnd1.equals(timeEnd2)) ||
                (timeStart1.isBefore(timeStart2) && timeEnd1.isAfter(timeEnd2));
    }


    private boolean doTimesOverlap(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return (start1.isAfter(start2) && start1.isBefore(end2)) ||
                (end1.isAfter(start2) && end1.isBefore(end2)) ||
                (start1.isEqual(start2) || end1.isEqual(end2)) ||
                (start1.isBefore(start2) && end1.isAfter(end2));
    }

    private boolean isSameRoomOrProfessor(Termin termin1, Termin termin2) {
        System.out.println("Checking if same room or professor"); // Logging the action

        // Check if rooms are the same
        if (termin1.getSoba() != null) {
            System.out.println(termin1.getSoba().getNaziv() + " : " + termin2.getSoba().getNaziv()); // Logging the room
            if (termin1.getSoba().getNaziv().equals(termin2.getSoba().getNaziv())) {
                return true;
            }
        }

        // Check if professors are the same
        if (termin1.getProfesor() != null) {
            return termin1.getProfesor().getIme().equals(termin2.getProfesor().getIme()) &&
                    termin1.getProfesor().getPrezime().equals(termin2.getProfesor().getPrezime());
        }

        System.out.println(termin1.toString());
        return false;
    }


    public Termin getFirstAvailable(QueryBuilder queryBuilder) {
        // Extract criteria from QueryBuilder
        LocalDateTime queryStart = queryBuilder.getPocetak();
        LocalDateTime queryEnd = queryBuilder.getKraj();
        int trajanje = queryBuilder.getTrajanje();
        boolean isReccuring = queryBuilder.isReccuring();

        // Iterate through each available room
        for (Soba availableSoba : sobe) {
            System.out.println("Checking room: " + availableSoba.getNaziv()); // Logging the room

            System.out.println("Rekviziti: " + availableSoba.getRekviziti().toString()); // Logging the room
            if (!availableSoba.getRekviziti().containsAll(queryBuilder.getRekviziti())) {

                System.out.println("Nema rekvizite"); // Logging the room
                continue;
            }
            if (availableSoba.getKapacitet() < queryBuilder.getKapacitet()) {
                continue;
            }
            if (availableSoba.getBrojRacunara() < queryBuilder.getBrojRacunara()) {
                continue;
            }
            if (queryBuilder.getSoba() != null && !queryBuilder.getSoba().getNaziv().equals(availableSoba.getNaziv())) {
                continue;
            }
            queryStart = queryBuilder.getPocetak(); // Reset the start time for each room

            while (!queryStart.plusMinutes(trajanje).isAfter(queryEnd)) {

                System.out.println("Trying soba: " + availableSoba.getNaziv()); // Logging the room
                Termin potentialTermin = new Termin(availableSoba, queryBuilder.getProfesor(),queryBuilder.getTipPredavanja(), queryStart, queryStart.plusMinutes(trajanje), "4343" ,isReccuring);

                Termin conflict = checkIfTerminIsAvailable(potentialTermin);
                if (conflict == null) {
                    // If the slot is available, return the new Termin
                    return potentialTermin;
                } else {
                    System.out.println("Conflict found with Termin: " + conflict.getSoba().getNaziv()); // Logging the conflict
                }

                // Move to a little after the end of the last conflicting Termin to avoid back-to-back conflicts
                queryStart = conflict.getKraj().plusMinutes(1);
            }
        }

        System.out.println("No available slot found in any room"); // Logging the final result
        return null; // No available slot found in any room
    }

}
