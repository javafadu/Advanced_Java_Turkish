package Ztest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Malzemeler {

    String porsiyon;

    List<String> malzemeler = new ArrayList<>(Arrays.asList("1-kimyon","2-isot","3-tuz","4-karabiber","5-sumak","6-bonfile","7-pirinc","8-kuyruk yağ"));

    List<String> dubleMiTekMi= new ArrayList<>();

    Malzemeler(){

    }

    Malzemeler(String x){
        System.out.println("Bu ana malzeme olmadan beyran olmaz. çıkartamazsınız");
    }


}
