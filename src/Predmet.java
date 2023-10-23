public class Predmet {
    private String naziv;

    public Predmet(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "naziv = '" + naziv + '\'' +
                '}';
    }
}
