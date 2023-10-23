package csv;

import java.io.*;
import java.util.Arrays;

public class CsvReader {
    public Csv readCsv(String fileName, Csv csv) {
        InputStream csvStream = CsvReader.class.getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(csvStream));
        String line = "";
        String cvsSplitBy = "\",";
        try  {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String predmetString = data[0].replace("\"", "");
                String tipString = data[1].replace("\"", "");
                String nastavnikString = data[2].replace("\"", "");
                String grupeStringArray[] = new String[]{data[3]};
                String grupeString = "";
                for(String s: grupeStringArray){
                    grupeString = grupeString +  s;
                }
                grupeString = grupeString.replace("\"", "");
                String danString = data[4].replace("\"", "");
                danString = danString.replace(" ", "");
                String terminString = data[5].replace("\"", "");
                String ucionicaString = data[6].replace("\"", "");

                if(!predmetString.contains("ZZ") && !nastavnikString.contains("ZZ")) {
                    CsvLine line1 = new CsvLine(predmetString, tipString, nastavnikString, grupeString, danString, terminString, ucionicaString);
                    csv.getCsvLines().add(line1);
/*
                    System.out.println(
                            "predmet = -" +
                                    predmetString + "- Tip = "+
                                    tipString + " Nastavnik = "+
                                    nastavnikString + " Grupe = "+
                                    grupeString + " dan = "+
                                    danString + " termin = "+
                                    terminString + " ucionica = "+
                                    ucionicaString + ";"

                    );*/

                }
                // Add code here to create and use Java objects
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csv;
    }
}
