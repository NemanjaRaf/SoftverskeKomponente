import java.util.ArrayList;
import java.util.List;

public interface Soba {

    public  String getNaziv();

    public int getKapacitet();

    public int getBrojRacunara();

    public  List<String> getRekviziti();

    public  void addRekvizit(String rekvizit);

    @Override
    public String toString();

    @Override
    public boolean equals(Object obj);
}
