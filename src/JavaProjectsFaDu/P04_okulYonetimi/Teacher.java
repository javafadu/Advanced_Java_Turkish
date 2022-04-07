package JavaProjectsFaDu.P04_okulYonetimi;

public class Teacher {

    private String name;
    private String branch;
    int mpno;


    // Teacher constructor, ogretmen objesi olusturmak icin
    public Teacher(String name, String branch, int mpno) {
        this.name = name;
        this.branch = branch;
        this.mpno = mpno;
    }
}