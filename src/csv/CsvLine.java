package csv;

import java.util.Arrays;

public class CsvLine {
    private String predmet;
    private String tip;
    private String profesor;
    private String grupe;
    private String dan;
    private String termin;
    private String ucionica;

    public CsvLine(String predmet, String tip, String profesor, String grupe, String dan, String termin, String ucionica) {
        this.predmet = predmet;
        this.tip = tip;
        this.profesor = profesor;
        this.grupe = grupe;
        this.dan = dan;
        this.termin = termin;
        this.ucionica = ucionica;
    }

    public String getPredmet() {
        return predmet;
    }

    public String getTip() {
        return tip;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getGrupe() {
        return grupe;
    }

    public String getDan() {
        return dan;
    }

    public String getTermin() {
        return termin;
    }

    public String getUcionica() {
        return ucionica;
    }

    @Override
    public String toString() {
        return "CsvLine{" +
                "predmet='" + predmet + '\'' +
                ", tip='" + tip + '\'' +
                ", profesor='" + profesor + '\'' +
                ", grupe='" + grupe + '\'' +
                ", dan='" + dan + '\'' +
                ", termin='" + termin + '\'' +
                ", ucionica='" + ucionica + '\'' +
                '}';
    }
}
