import csv.Csv;
import csv.CsvLine;

import java.time.LocalDateTime;

public class Parser {
    public static Raspored CsvToRaspored(Raspored raspored, Csv csv){
        for(int i = 1; i < csv.getCsvLines().size(); i++){
            CsvLine l = csv.getCsvLines().get(i);

            Soba soba = new Soba(l.getUcionica(), 20, 20);
            raspored.addSoba(soba);

            Predmet predmet = new Predmet(l.getPredmet());

            String ime = l.getProfesor();
            String prezime = "";
            String[] splitter = l.getProfesor().split(" ");
            if(splitter.length > 1) {
                ime = splitter[0];
                prezime = splitter[1];
            }
            Profesor profesor = new Profesor(ime, prezime, predmet);


            String grupe = l.getGrupe();

            String timeStr = l.getTermin();
            String[] times = timeStr.split("-");

            String startTime = times[0];
            String endTime = times[1].length() == 2 ? times[1] + ":00" : times[1];
            String dateStr = "2023-10-30";
            switch (l.getDan()){
                case "PON": dateStr = "2023-10-30";break;
                case "UTO": dateStr = "2023-10-31";break;
                case "SRE": dateStr = "2023-11-01";break;
                case "ČET": dateStr = "2023-11-02";break;
                case "PET": dateStr = "2023-11-03";break;
            }

            String startDateTimeStr = dateStr + "T" + startTime + ":00";
            String endDateTimeStr = dateStr + "T" + endTime + ":00";
            LocalDateTime pocetak = LocalDateTime.parse(startDateTimeStr);
            LocalDateTime kraj = LocalDateTime.parse(endDateTimeStr);

            TipPredavanja tipPredavanja = null;
            switch (l.getTip()){
                case "P": tipPredavanja = TipPredavanja.PREDAVANJE;break;
                case "V": tipPredavanja = TipPredavanja.VEZBE;break;
                case "D": tipPredavanja = TipPredavanja.DEMONSTRACIJE;break;
            }

            Termin termin = new Termin(soba, profesor, tipPredavanja, pocetak, kraj, grupe,true);
            //System.out.println(termin);
            raspored.addTermin(termin, false);
        }
        return raspored;
    }
}
