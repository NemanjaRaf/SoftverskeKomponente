import java.util.ArrayList;
import java.util.List;

public class Soba {
    private String naziv;
    private int kapacitet, brojRacunara;

    private List<Rekviziti> rekviziti;

    public Soba(String naziv, int kapacitet, int brojRacunara) {
        this.naziv = naziv;
        this.kapacitet = kapacitet;
        this.brojRacunara = brojRacunara;

        rekviziti = new ArrayList<>();
    }


    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public String getNaziv() {
        return naziv;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public int getBrojRacunara() {
        return brojRacunara;
    }

    public List<Rekviziti> getRekviziti() {
        return rekviziti;
    }

    public void addRekvizit(Rekviziti rekvizit) {
        if (rekviziti == null) {
            rekviziti = new ArrayList<>();
        }
        rekviziti.add(rekvizit);
    }

    @Override
    public String toString() {
        return "Soba{" +
                "naziv = '" + naziv + '\'' +
                ", kapacitet = " + kapacitet +
                ", brojRacunara = " + brojRacunara +
                ", rekviziti = " + rekviziti +
                '}';
    }
}
