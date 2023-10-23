import java.util.ArrayList;
import java.util.List;

public class DynamicSoba implements Soba {
    private String naziv;
    private int kapacitet;
    private int brojRacunara;
    private List<String> rekviziti;

    public DynamicSoba(String naziv, int kapacitet, int brojRacunara) {
        this.naziv = naziv;
        this.kapacitet = kapacitet;
        this.brojRacunara = brojRacunara;
        this.rekviziti = new ArrayList<>();
    }

    @Override
    public String getNaziv() {
        return naziv;
    }

    @Override
    public int getKapacitet() {
        return kapacitet;
    }

    @Override
    public int getBrojRacunara() {
        return brojRacunara;
    }

    @Override
    public List<String> getRekviziti() {
        return rekviziti;
    }

    @Override
    public void addRekvizit(String rekvizit) {
        rekviziti.add(rekvizit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Soba) {
            Soba soba = (Soba) obj;
            return soba.getNaziv().equals(naziv);
        }
        return false;
    }
}
