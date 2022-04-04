package projectsFaDu.P02_javaBankATM;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class User {

    static String kartNumarasi = "12345678";
    static String sifre = "123";
    static double bakiye = 5000;
    static String yeniKullaniciKart = "";
    static Scanner scan = new Scanner(System.in);

    public static void atmGiris() {
        System.out.print("Kart numarasini giriniz : ");
        String kullaniciKart = scan.nextLine();
        kullaniciKartKontrol(kullaniciKart);
        System.out.print("Sifrenizi giriniz : ");
        String kullaniciSifre = scan.nextLine();
        kullaniciGirisKontrol(kullaniciKart, kullaniciSifre);
    }

    private static String kullaniciKartKontrol(String kullaniciKart) {

        String kullaniciKartArr[] = kullaniciKart.replaceAll(" ", "").split("");
        for (int i = 0; i < kullaniciKartArr.length; i++) {
            yeniKullaniciKart += kullaniciKartArr[i];
        }
        return yeniKullaniciKart;
    }

    public static void kullaniciGirisKontrol(String kullaniciKart, String kullaniciSifre) {
        if (!yeniKullaniciKart.equals(kartNumarasi) || !kullaniciSifre.equals(sifre)) {
            System.out.println("Kart numaraniz ya da sifrenizi yanlis girdininiz. Lutfen tekrar giriniz");
            yeniKullaniciKart = "";
            atmGiris();
        } else {
            Transactions.islemMenusu();
        }
    }


}
