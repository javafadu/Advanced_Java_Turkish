package Ztest;

public class SefimBanaBiBeyran {

   private String malzemeler;
   private String porsiyon="Tek Seçim";

    public SefimBanaBiBeyran(String malzemeler, String porsiyon) {
        this.malzemeler = malzemeler;
        this.porsiyon = porsiyon;
    }

    public String getMalzemeler() {
        return malzemeler;
    }

    public void setMalzemeler(String malzemeler) {
        this.malzemeler = malzemeler;
    }

    public String getPorsiyon() {
        return porsiyon;
    }

    public void setPorsiyon(String porsiyon) {
        this.porsiyon = porsiyon;
    }




}
