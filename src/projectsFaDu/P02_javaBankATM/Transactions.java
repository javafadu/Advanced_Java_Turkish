package projectsFaDu.P02_javaBankATM;

import java.util.Scanner;

public class Transactions {

    static int secilenIslem;
    static int count;
    static Scanner scan = new Scanner(System.in);

    public static void islemMenusu() {
        System.out.println("Lutfen islem menusunden yapmak istediginiz islemi tuslayiniz" +
                "\n1.Bakiye Sorgulama" +
                "\n2.Para Yatirma" +
                "\n3.Para Cekme" +
                "\n4.Para Gonderme" +
                "\n5.Sifre Degistirme" +
                "\n6.Cikis");
        secilenIslem = scan.nextInt();
        scan.nextLine(); // scan.nextInt()'den sonra ki scan methodunu atlamamasi icin scan.nextLine() eklememiz gerekir.
        switch (secilenIslem) {
            case 1:
                bakiyeSorgulama();
                break;
            case 2:
                paraYatirma();
                break;
            case 3:
                paraCekme();
                break;
            case 4:
                paraGonderme();
                break;
            case 5:
                sifreDegistirme();
                break;
            case 6:
                cikis();
                break;
        }
    }

    private static void sifreDegistirme() {
        String mevcutSifre = "";
        String yeniSifre = "";
        System.out.print("Lutfen mevcut sifrenizi giriniz : ");
        mevcutSifre=scan.nextLine();
        if (User.sifre.equals(mevcutSifre)){
            System.out.print("Lutfen yeni sifreyi giriniz : ");
            yeniSifre = scan.nextLine();
            System.out.println("Sifreniz basariyla guncellenmistir");
            User.sifre=yeniSifre;
        }else{
            count++;
            if (count==3){
                System.out.println("Sifrenizi 3 kere yanlis girdiniz.");
                islemMenusu();
            }
            System.out.println("Sifrenizi yanlis girdiniz.");
            sifreDegistirme();
        }

    }

    private static void cikis() {
        System.out.println("Cikisiniz gerceklestiriliyor...Bizi tercih ettiginiz icin tesekkurler");
    }

    private static void paraGonderme() {
        System.out.println("Gondermek istediginiz miktari giriniz : ");
        double gonderilecekMiktar = scan.nextDouble();
        if (gonderilecekMiktar <= User.bakiye) {
            scan.nextLine();
            System.out.println("Gondermek istediginiz IBAN numarasini giriniz : ");
            String iban = scan.nextLine();
            if (iban.startsWith("TR") && iban.length()==26) {
                System.out.println("Paraniz " + iban + " numarali hesaba gonderilmistir.");
                User.bakiye -= gonderilecekMiktar;
                bakiyeSorgulama();
            } else {
                System.out.println("Girdiginiz IBAN hatalidir ya da eksik girdiniz");
                paraGonderme();
            }
        } else {
            System.out.println("Hesabinizda gondermek istediginiz kadar para bulunmamaktadir");
            paraGonderme();
        }


    }

    private static void paraCekme() {
        System.out.println("Cekmek istediginiz miktari giriniz : ");
        double cekilecekMiktar = scan.nextDouble();
        if (cekilecekMiktar <= User.bakiye)
            System.out.println("Lutfen ATM'den paranizi almayi unutmayiniz\nGuncel Bakiye : " + (User.bakiye - cekilecekMiktar));
        else {
            System.out.println("Hesabinizda cekmek istediginiz kadar para bulunmamaktatdir");
            paraCekme();
        }
    }

    private static void paraYatirma() {
        System.out.println("Yatirmak istediginiz miktari giriniz : ");
        double yatirilacakMiktar = scan.nextDouble();
        System.out.println("Lutfen ATM'den paranizi almayi unutmayiniz\nGuncel Bakiye : " + (User.bakiye + yatirilacakMiktar));
    }

    private static void bakiyeSorgulama() {
        System.out.println("Guncel Bakiye : " + User.bakiye);
    }
}
