import java.time.LocalDateTime;
import java.util.HashMap;

public class Termin {
    private Soba soba;
    private HashMap<String, String> additionalData;
    private LocalDateTime pocetak, kraj;
    private boolean reccuring;

    public Termin(Soba soba, LocalDateTime pocetak, LocalDateTime kraj, boolean reccuring) {
        if (pocetak.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Ne moze se zakazati termin u proslosti!");
        }
        if (pocetak.isAfter(kraj)) {
            throw new IllegalArgumentException("Pocetak termina ne moze biti posle kraja termina!");
        }
        this.soba = soba;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.reccuring = reccuring;
        this.additionalData = new HashMap<>();
    }

    public HashMap<String, String> getAdditionalData() {
        return additionalData;
    }

    public void addAdditionalData(String key, String value) {
        additionalData.put(key, value);
    }

    public Soba getSoba() {
        return soba;
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

    @Override
    public String toString() {
        return "Termin{" +
                "soba = " + soba +
                ", pocetak = " + pocetak +
                ", kraj = " + kraj +
                ", reccuring = " + reccuring +
                '}';
    }
}
