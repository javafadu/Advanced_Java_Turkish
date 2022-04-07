package Ztest;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Beyran_Methods extends Malzemeler{

    static Scanner scanner = new Scanner(System.in);
    static List<String> musteriMalzemeSecim = new ArrayList<>(Arrays.asList("1-kimyon","2-isot","3-tuz","4-karabiber","5-sumak","6-bonfile","7-pirinc","8-kuyruk yağ"));
    static String[] menu = {"1-Mercimek Çorba","2-Tereyağlı Küşneme","3-Kaburga Şiş","4-Beyran"};
    static double brFiyat[]={0.00,0.00,0.00,35};





    public  void menuSecim(){

        System.out.println("Lütfen Seçiminizi Numara Olarak Yapınız: ");
        System.out.println("");

        System.out.println("YEMEK İSMİ                     FİYAT");
        System.out.println("=====================================");
        for (int i = 0; i <menu.length ; i++) {
            System.out.printf("%-19S           $%3.2f\n",menu[i],brFiyat[i]);
        }

        System.out.println("=====================================");
        int secim = scanner.nextInt();
        if(secim!=4){
            System.out.println("Üzgünüz şuan sadece beyranımız mevcuttur");
            menuSecim();
        } else {
            scanner.nextLine();
            porsiyonSecim();

        }

    }

    private void porsiyonSecim() {


        System.out.println("Tek Porsiyon(T) /  Duble(D) ?     T/D? ");
        String porsiyon = scanner.nextLine();
        if(porsiyon.equalsIgnoreCase("d")){
            super.porsiyon="Duble Seçim"; // inheritance ile parent classtaki(malzemeler.java) porsiyon variable'ına yeni atama yaptık
        } else if(porsiyon.equalsIgnoreCase("t")){
            super.porsiyon="Tek Seçim";
        } else {System.out.println("yanlış porsiyon seçimi. tekrar porsyion seçime yönlendiriyorum: "); porsiyonSecim();}


        malzemeSecim();

    }//porsiyonSecim();

    public void malzemeSecim() {


        System.out.println(super.malzemeler);// malzemeler parent class'taki listeyi  super methoduyla getirdi

        System.out.println("Lütfen çıkarmak istediğiniz malzemeleri seçiniz, seçim bittiğinde veya çıkmak istediğinizde 0'a basınız ");



        while(true) {//cikarilan malzemeleri belirler
            int istemiyorum = scanner.nextInt();
            if(istemiyorum==0){
                break;
            } else if(istemiyorum>5 && istemiyorum<9){
                new Malzemeler("x");
            } else if(istemiyorum>0 && istemiyorum<6){
                musteriMalzemeSecim.set((istemiyorum-1),"-");
            }
            else {
                System.out.println("Yanlış seçim yaptınız. Sizi malzeme seçim menüsüne tekrar yönlendiriyorum");
                malzemeSecim();
            }
        }

        Collections.sort(musteriMalzemeSecim);

        while(true){///çıkarılan malzemeleri menüden tek tek kaldırır
            if(!musteriMalzemeSecim.get(0).equalsIgnoreCase("-")){
                break;
            }else {
                musteriMalzemeSecim.remove(0);
            }
        }

        System.out.println("Çıkarılanlardan sonra kalan malzemeler: ");
        System.out.println(musteriMalzemeSecim);

        beyranHazirla();


    }

    public void beyranHazirla() {

        StringBuilder malzeme = new StringBuilder();
        for (int i = 0; i <musteriMalzemeSecim.size() ; i++) {
            malzeme.append(musteriMalzemeSecim.get(i)+" ");
        }

      SefimBanaBiBeyran beyran1 = new SefimBanaBiBeyran(malzeme.toString(),super.porsiyon);

        System.out.println("Beyranının hazır. Malzemeler: "+beyran1.getMalzemeler()+" Porsiyon: "+beyran1.getPorsiyon());
        System.out.println("");

        fisYazdir();

    }

    public void fisYazdir() {

        String sipairs[] = {"Beyran"};

        LocalTime tarihSaat= LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");

        System.out.println("ANTEPLİ  ÜSTADIM  LEZZET  SOFRASI");
        System.out.println("Saat: "+formatter.format(tarihSaat));
        System.out.println("");

        System.out.println("SİPARİŞ        PORSİYON      FİYAT");
        System.out.println("==================================");
        for (int i = 0; i <sipairs.length ; i++) {
            System.out.printf("%-7S     %-8s      %-3.2f\n",sipairs[i],super.porsiyon,brFiyat[3]*2);

        }
        System.out.println("==================================");
        System.out.println("AFİYET OLSUN YİNE BEKLERİZ");





    }


}
