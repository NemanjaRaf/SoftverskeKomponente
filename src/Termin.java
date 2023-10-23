import java.time.LocalDateTime;
import java.time.Period;

public class Termin {
    private Soba soba;
    private Profesor profesor;
    private TipPredavanja tipPredavanja;
    private LocalDateTime pocetak, kraj;
    private String grupe;
    private boolean reccuring;

    public Termin(Soba soba, Profesor profesor,TipPredavanja tipPredavanja, LocalDateTime pocetak, LocalDateTime kraj,String grupe, boolean reccuring) {
        if (pocetak.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Ne moze se zakazati termin u proslosti!");
        }
        if (pocetak.isAfter(kraj)) {
            throw new IllegalArgumentException("Pocetak termina ne moze biti posle kraja termina!");
        }
        this.soba = soba;
        this.profesor = profesor;
        this.tipPredavanja = tipPredavanja;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.grupe = grupe;
        this.reccuring = reccuring;
    }

    public TipPredavanja getTipPredavanja() {
        return tipPredavanja;
    }

    public void setTipPredavanja(TipPredavanja tipPredavanja) {
        this.tipPredavanja = tipPredavanja;
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

    public String getGrupe() {
        return grupe;
    }

    public void setGrupe(String grupe) {
        this.grupe = grupe;
    }

    @Override
    public String toString() {
        return "Termin{" +
                "soba = " + soba +
                ", profesor = " + profesor +
                ", tip predavanja = " + tipPredavanja +
                ", grupe = " + grupe +
                ", pocetak = " + pocetak +
                ", kraj = " + kraj +
                ", reccuring = " + reccuring +
                '}';
    }
}
