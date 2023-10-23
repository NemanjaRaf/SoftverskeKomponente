import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QueryBuilder {
    public List<String> getRekviziti() {
        return rekviziti;
    }

    private int brojRacunara, kapacitet, trajanje;
    private LocalDateTime pocetak, kraj;
    private Soba soba;
    private List<String> rekviziti;
    private HashMap<String, String> additionalData;
    private boolean reccuring;
    public int getBrojRacunara() {
        return brojRacunara;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public LocalDateTime getPocetak() {
        return pocetak;
    }

    public LocalDateTime getKraj() {
        return kraj;
    }

    public Soba getSoba() {
        return soba;
    }

    public HashMap<String, String> getAdditionalData() {
        return additionalData;
    }

    public void addAdditionalData(String key, String value) {
        additionalData.put(key, value);
    }

    public QueryBuilder() {
        rekviziti = new ArrayList<>();
        additionalData = new HashMap<>();
    }

    public QueryBuilder setReccuring(boolean reccuring) {
        this.reccuring = reccuring;
        return this;
    }

    public boolean isReccuring() {
        return reccuring;
    }

    public QueryBuilder setBrojRacunara(int brojRacunara) {
        this.brojRacunara = brojRacunara;
        return this;
    }

    public QueryBuilder setTrajanje(int trajanje) {
        this.trajanje = trajanje;
        return this;
    }

    public QueryBuilder setSoba(Soba soba) {
        this.soba = soba;
        return this;
    }

    public QueryBuilder setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
        return this;
    }

    public QueryBuilder setPocetak(LocalDateTime pocetak) {
        this.pocetak = pocetak;
        return this;
    }

    public QueryBuilder setKraj(LocalDateTime kraj) {
        this.kraj = kraj;
        return this;
    }

    public QueryBuilder addRekvizit(String rekvizit) {
        rekviziti.add(rekvizit);
        return this;
    }

    @Override
    public String toString() {
        return "QueryBuilder{" +
                "brojRacunara = " + brojRacunara +
                ", kapacitet = " + kapacitet +
                ", trajanje = " + trajanje +
                ", pocetak = " + pocetak +
                ", kraj = " + kraj +
                ", soba = " + soba +
                ", rekviziti = " + rekviziti +
                ", reccuring = " + reccuring +
                '}';
    }
}
