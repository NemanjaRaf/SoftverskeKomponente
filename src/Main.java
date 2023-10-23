import csv.Csv;
import csv.CsvReader;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Raspored raspored = new Raspored();
//
//        Soba s1 = new DynamicSoba("RAF1", 20, 20);
//        Soba s2 = new Soba("RAF2", 20, 20);
//        Soba s3 = new Soba("RAF3", 20, 20);
//        s3.addRekvizit(Rekviziti.PROJEKTOR);
//
//        raspored.addSoba(s1);
//        raspored.addSoba(s2);
//        raspored.addSoba(s3);
//
//        Termin t1 = new Termin(s1, new Profesor("Pera", "Peric", new Predmet("Bleja")),TipPredavanja.VEZBE, LocalDateTime.now().plusDays(7).plusMinutes(1), LocalDateTime.now().plusDays(7).plusHours(2), "101", true);
//        Termin t2 = new Termin(s2, new Profesor("Peraaaa", "Peric", new Predmet("Bleja")),TipPredavanja.DEMONSTRACIJE, LocalDateTime.now(), LocalDateTime.now().plusHours(10), "101",false);
//        Termin t3 = new Termin(s3, new Profesor("Peraaa", "Peric", new Predmet("Bleja")),TipPredavanja.PREDAVANJE, LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(3).plusHours(2), "101",false);
//
//
//        raspored.addTermin(t1, false);
//        raspored.addTermin(t2, false);
//        raspored.addTermin(t3, false);
//
//        raspored.moveTermin(t3, LocalDateTime.now().plusDays(7), LocalDateTime.now().plusDays(7).plusHours(2));
//
//        QueryBuilder query = new QueryBuilder()
//                .setKapacitet(20)
//                .addRekvizit(Rekviziti.PROJEKTOR)
//                .setPocetak(LocalDateTime.now().plusMinutes(1))
//                .setKraj(LocalDateTime.now().plusHours(3))
//                .setTrajanje(30)
//                .setReccuring(true)
//                .setTipPredavanja(TipPredavanja.PREDAVANJE);
//
//        Termin t = raspored.getFirstAvailable(query);
//        if (t != null) {
//            System.out.println(t.getPocetak().toString() + " " + t.getKraj().toString());
//        } else {
//            System.out.println("Nema slobodnih termina!");
//        }


        CsvReader csvReader = new CsvReader();
        Csv csv = new Csv();
        csv = csvReader.readCsv("/data/csv.csv", csv);
        raspored = Parser.CsvToRaspored(raspored, csv);
        QueryBuilder query = new QueryBuilder()
//                .setSoba(new DynamicSoba("Raf02 (u)", 20, 20))
                .setKapacitet(20)
                .setPocetak(LocalDateTime.now().plusDays(7).minusMinutes(300))
                .setKraj(LocalDateTime.now().plusDays(7).plusHours(5))
                .setTrajanje(120)
                .setReccuring(false);
        System.out.println("=================================================");
        Termin t = raspored.getFirstAvailable(query);
        if (t != null) {
            System.out.println(t.getPocetak().toString() + " " + t.getKraj().toString());
        } else {
            System.out.println("Nema slobodnih termina!");
        }
//        for(Termin tt: raspored.getTermini()){
//            if (tt.getSoba().getNaziv().equalsIgnoreCase("Raf02 (u)"))
//                System.out.println(tt.toString());
//        }



        //System.out.println(t1);
        //System.out.println(t2);
        //System.out.println(t3);
        //System.out.println(query);

    }
}
