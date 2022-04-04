package _12_VarargsFaDu;

public class Q01 {
    public Q01() {
    }

    public static void main(String[] args) {
        String str1 = "m";
        String str2 = "e";
        String str3 = "r";
        String str4 = "v";
        String str5 = "e";
        concat(str1, str2, str3, str4, str5);
    }

    private static void concat(String... str) {
        String birlesmis = "";
        String[] var2 = str;
        int var3 = str.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String each = var2[var4];
            birlesmis = birlesmis + each;
        }

        System.out.println(birlesmis);
    }
}


