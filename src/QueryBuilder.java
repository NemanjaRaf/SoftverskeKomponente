import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
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

    public Profesor getProfesor() {
        return profesor;
    }

    public Soba getSoba() {
        return soba;
    }

    public List<Rekviziti> getRekviziti() {
        return rekviziti;
    }

    private int brojRacunara, kapacitet, trajanje;
    private LocalDateTime pocetak, kraj;
    private Profesor profesor;
    private TipPredavanja tipPredavanja;
    private Soba soba;
    private List<Rekviziti> rekviziti;
    private boolean reccuring;

    public QueryBuilder() {
        rekviziti = new ArrayList<>();
    }

    public QueryBuilder setReccuring(boolean reccuring) {
        this.reccuring = reccuring;
        return this;
    }

    public TipPredavanja getTipPredavanja() {
        return tipPredavanja;
    }

    public QueryBuilder setTipPredavanja(TipPredavanja tipPredavanja) {
        this.tipPredavanja = tipPredavanja;
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

    public QueryBuilder setProfesor(Profesor profesor) {
        this.profesor = profesor;
        return this;
    }

    public QueryBuilder addRekvizit(Rekviziti rekvizit) {
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
                ", profesor = " + profesor +
                ", tipPredavanja = " + tipPredavanja +
                ", soba = " + soba +
                ", rekviziti = " + rekviziti +
                ", reccuring = " + reccuring +
                '}';
    }
}
