import java.time.LocalDateTime;
import java.time.Period;

public class Termin {
    private Soba soba;
    private Profesor profesor;
    private LocalDateTime pocetak, kraj;
    private boolean reccuring;

    public Termin(Soba soba, Profesor profesor, LocalDateTime pocetak, LocalDateTime kraj, boolean reccuring) {
        if (pocetak.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Ne moze se zakazati termin u proslosti!");
        }
        if (pocetak.isAfter(kraj)) {
            throw new IllegalArgumentException("Pocetak termina ne moze biti posle kraja termina!");
        }
        this.soba = soba;
        this.profesor = profesor;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.reccuring = reccuring;
    }

    public Soba getSoba() {
        return soba;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public LocalDateTime getPocetak() {
        return pocetak;
    }

    public LocalDateTime getKraj() {
        return kraj;
    }

    public boolean isReccuring() {
        return reccuring;
    }

    public void setPocetak(LocalDateTime pocetak) {
        this.pocetak = pocetak;
    }

    public void setKraj(LocalDateTime kraj) {
        this.kraj = kraj;
    }
}
