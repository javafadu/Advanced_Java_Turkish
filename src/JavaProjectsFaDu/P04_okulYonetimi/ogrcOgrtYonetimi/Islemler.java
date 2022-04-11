package JavaProjectsFaDu.P04_okulYonetimi.ogrcOgrtYonetimi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Islemler {

    static List<Kisi> ogrenciListesi = new ArrayList<>();
    static List<Kisi> ogretmenListesi = new ArrayList<>();
    static Scanner scan = new Scanner (System.in);
    static String kisiTuru;


    public static void girisPaneli() {
        System.out.println("====================================\nOGRENCI VE OGRETMEN YONETIM PANELI\n" +
                "====================================\n"
                + "1- OGRENCI ISLEMLERI\n2- OGRETMEN ISLEMLERI\nQ- CIKIS");
        System.out.print("isleminiz seciniz : ");
        String secim=scan.next().toUpperCase();

        switch (secim) {
            case "1":
                kisiTuru="OGRENCI";
                islemMenusu();
                break;
            case "2":
                kisiTuru="OGRETMEN";
                islemMenusu();
                break;
            case "Q":
                cikisIslemi();
                break;
            default:
                System.out.println("Hatali Giris Yaptiniz");
                girisPaneli();
                break;

        }

    }

    private static void cikisIslemi() {
        System.out.println("Tesekkur Ederiz, Iyi Gunler");
    }

    // ALT ISLEMLER MENUSU
    public static void islemMenusu() {
        System.out.println("Sectiginiz  Kişi turu: "+ kisiTuru+" icin  aşağıdaki işlemlerden tercih yapınız.\r\n"
                + "============= İŞLEMLER =============\r\n"
                + "     1-EKLEME\r\n"
                + "     2-ARAMA\r\n"
                + "     3-LİSTELEME\r\n"
                + "     4-SİLME\r\n"
                + "     0-ANA MENU");

        System.out.print("islem tercihinizi giriniz : ");
        scan.nextLine(); // dummy scan, bir sonraki scan i atlamamasi icin
        int secilenIslem = scan.nextInt();


        switch(secilenIslem) {
            case 1:
                ekle();
                islemMenusu();
                break;
            case 2:
                islemMenusu();
                break;
            case 3:
                islemMenusu();
                break;
            case 4:
                islemMenusu();
                break;
            case 0:
                girisPaneli();
                break;
            default:
                System.out.println("Hatali Giris Yaptiniz");
                islemMenusu();
                break;

        }


    }

    private static void ekle() {

        System.out.println("   ****   "+kisiTuru+" EKLEME SAYFASI   ****");
        System.out.print("Ad Soyad Giriniz : ");
        String adSoyad = scan.nextLine();
        scan.nextLine(); // dummy scan
        System.out.print("Kimlik No Giriniz : ");
        String kimlikNo = scan.nextLine();
        System.out.print("Yas Giriniz : ");
        int yas = scan.nextInt();

        if(kisiTuru.equals("OGRENCI")) {
            System.out.print("Ogrenci No Giriniz : ");
            String ogrenciNo = scan.nextLine();
            scan.nextLine(); // dummy scan
            System.out.print("Sinif Giriniz : ");
            String sinif = scan.nextLine();

            Ogrenci sefilOgrenci = new Ogrenci(adSoyad,kimlikNo,yas,ogrenciNo,sinif);
            ogrenciListesi.add(sefilOgrenci);

            // parametreli constructor dan ogrenci objesi create edilecek

        } else {
            System.out.print("Sicil No Giriniz : ");
            String sicilNo = scan.nextLine();
            System.out.print("Bolum Giriniz : ");
            String bolum = scan.nextLine();

            Ogretmen muhtesemOgretmen = new Ogretmen(adSoyad,kimlikNo,yas,sicilNo,bolum);
            ogrenciListesi.add(muhtesemOgretmen);
        }





    }


}
