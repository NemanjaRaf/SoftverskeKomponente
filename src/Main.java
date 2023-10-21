import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Raspored raspored = new Raspored();

        Soba s1 = new Soba("RAF1", 20, 20);
        Soba s2 = new Soba("RAF2", 20, 20);
        Soba s3 = new Soba("RAF3", 20, 20);
        s3.addRekvizit(Rekviziti.PROJEKTOR);

        raspored.addSoba(s1);
        raspored.addSoba(s2);
        raspored.addSoba(s3);

        Termin t1 = new Termin(s1, new Profesor("Pera", "Peric", new Predmet("Bleja")), LocalDateTime.now().plusDays(7).plusMinutes(1), LocalDateTime.now().plusDays(7).plusHours(2), true);
        Termin t2 = new Termin(s2, new Profesor("Peraaaa", "Peric", new Predmet("Bleja")), LocalDateTime.now(), LocalDateTime.now().plusHours(10), false);
        Termin t3 = new Termin(s3, new Profesor("Peraaa", "Peric", new Predmet("Bleja")), LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(3).plusHours(2), false);


        raspored.addTermin(t1, false);
        raspored.addTermin(t2, false);
        raspored.addTermin(t3, false);

//        raspored.moveTermin(t3, LocalDateTime.now().plusDays(7), LocalDateTime.now().plusDays(7).plusHours(2));

        QueryBuilder query = new QueryBuilder()
                .setKapacitet(20)
                .addRekvizit(Rekviziti.PROJEKTOR)
                .setPocetak(LocalDateTime.now().plusMinutes(1))
                .setKraj(LocalDateTime.now().plusHours(3))
                .setTrajanje(30)
                .setReccuring(true)
                .setProfesor(new Profesor("Marko", "Peric", new Predmet("Bleja")));

        Termin t = raspored.getFirstAvailable(query);
        if (t != null) {
            System.out.println(t.getPocetak().toString() + " " + t.getKraj().toString());
        } else {
            System.out.println("Nema slobodnih termina!");
        }


    }
}
