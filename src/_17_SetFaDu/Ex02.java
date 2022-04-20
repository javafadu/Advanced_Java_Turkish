package _17_SetFaDu;

import java.util.ArrayList;
import java.util.Collections;

public class Ex02 {

    /*  Method:
           10 ve 5 elemanli, elemanlari 0-20 arasinda değer alan 2 adet  ArrayList create edin ve
        elemanlarini aldigi min, max degerleri arasindaki random sayi ile doldurup
        sonucta bir ArrayList return eden bir method yaziniz
        main:
        1.  Yazdiginiz Methodu kullanarak bir 10 ve 5 elemanli
            elemanlari 0-20 arasinda 2 adet ArrayList olusturun
        2.  Bu iki list'in ortak elemanlarini bulunuz
        3.  Bu iki list'in farkli olan elemanlarini bulunuz
        4.  Bu listleri birbirine ekleyip önce kücükten büyüge sonra ters siralayiniz

     Collections.sort(arr1)


     */


    public static void main(String[] args) {
        int min = 0; // dahil
        int max = 21; // dahil degil
        int randomSayi = (int) (Math.random() * (max - min)) + min;

        ArrayList<Integer> arrList1 = new ArrayList<>();
        ArrayList<Integer> arrList2 = new ArrayList<>();

        arrList1=arrListHazira(10,5,20);
        arrList2=arrListHazira(5,0,20);

        System.out.println("List1: "+arrList1);
        System.out.println("List2: "+arrList2);


        ArrayList<Integer> arrayListFark1 = new ArrayList<>(); // list1 de olup list2 de olmayan (list1-list2)
        ArrayList<Integer> arrayListFark2 = new ArrayList<>(); // list2 de olup list1 de olmayan (list2-list1)



        arrayListFark1=arrList1;
        arrayListFark1.removeAll(arrList2);
        System.out.println("ArrayList1 Fark: "+arrayListFark1 );

        arrayListFark2=arrList2;
        arrayListFark2.removeAll(arrList1);
        System.out.println("ArrayList2 Fark: "+arrayListFark2 );

        arrayListFark2.addAll(arrayListFark1); // fark listeleri eklendi
        Collections.sort(arrayListFark2); // k->b
        Collections.reverse(arrayListFark2); // b->k


    }

    public static int getRandom(int min, int max) { // max min arasinda random sayi return eder

        return (int) (Math.random()*(max-min+1));
    }


    private static ArrayList<Integer> arrListHazira(int size, int min, int max) {
        // bu method create edilecek arrList size kadar min max arasinda int sayi uretip
        // liste atar

        ArrayList<Integer> bosList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bosList.add(getRandom(min,max));
        }
        return bosList;
    }
}
