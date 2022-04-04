package _12_VarargsFaDu;

public class Q02 {
    public Q02() {
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 6;
        int num3 = 7;
        int num4 = 8;
        int num5 = 9;
        int num6 = 4;
        int num7 = 13;
        int num8 = 17;
        topla(num1, num2, num3, num4, num5, num6, num7, num8);
    }

    public static void topla(int carpilacakSayi, int... toplanacakSayilar) {
        int toplam = 0;
        int[] var3 = toplanacakSayilar;
        int var4 = toplanacakSayilar.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            int each = var3[var5];
            toplam += each;
        }

        System.out.println("Sonuc : " + carpilacakSayi * toplam);
    }
}
