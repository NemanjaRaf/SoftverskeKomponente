/**
 * Constructs an empty list with an initial capacity of ten.
 */
public class Profesor {
    private String ime, prezime;
    private Predmet predmet;

    public Profesor(String ime, String prezime, Predmet predmet) {
        this.ime = ime;
        this.prezime = prezime;
        this.predmet = predmet;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public Predmet getPredmet() {
        return predmet;
    }
}
