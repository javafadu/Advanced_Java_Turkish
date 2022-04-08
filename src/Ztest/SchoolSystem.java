package Ztest;
import java.util.ArrayList;

public class SchoolSystem {

    public static void main(String[] args) {
        // Atamalar hardcode yapıldı. Gerekirse scan ile yapılabilir.
        // Öğretmen oluşturma
        Teacher t1 = new Teacher("Ayse Narin", "Fen Bilimleri", 101);
        Teacher t2 = new Teacher("Ali Karan", "Matematik", 102);
        Teacher t3 = new Teacher("Asya Ararat", "Sosyal Bilimler", 103);

        // Ders oluşturma
        Course c1 = new Course("Fen Bilgisi", "FB", "D01", 25);
        Course c2 = new Course("Matematik", "MT", "D02", 20);
        Course c3 = new Course("Hayat Bilgisi", "HB", "D03", 30);

        // Derslere öğretmen atama
        c1.addTeacher(t1);
        c2.addTeacher(t2);
        c3.addTeacher(t3);

        // Öğrenci oluşturma
        Student s1 = new Student("Ali Veli", 201, c1, c2, c3);
        Student s2 = new Student("Kırkdokuz Elli", 202, c1, c2, c3);

        // Öğrenci için not girişi yapma (ders, yazılı notu, sözlü notu) şeklinde metoda gönderilen bilgiyle ortalama hesaplanır.
        // Her dersin objesinin içinde c1.note şeklinde o dersin sözlü notunun % ağırlık bilgisi var.
        s1.addBulkExamNote(c1, 60, 75);
        s1.addBulkExamNote(c2, 55, 85);
        s1.addBulkExamNote(c3, 75, 55);
        s2.addBulkExamNote(c1, 90, 70);
        s2.addBulkExamNote(c2, 85, 80);
        s2.addBulkExamNote(c3, 10, 20);

        // Yazdırmalar fonksiyonları denemek için yapıldı. Gerekli olmayanlar silinebilir.
        // Dersleri tek tek yazdırma
        System.out.println("Ders  :\t" + c1.name + "\nKod   :\t" + c1.code + "\nÖnek  :\t" + c1.prefix);
        c1.printTeacher();
        System.out.println("Not   :\tBu derste sözlü notunun etkisi %" + c1.note + " olacaktır.");
        System.out.println();

        System.out.println("Ders  :\t" + c2.name + "\nKod   :\t" + c2.code + "\nÖnek  :\t" + c2.prefix);
        c2.printTeacher();
        System.out.println("Not   :\tBu derste sözlü notunun etkisi %" + c2.note + " olacaktır.");
        System.out.println();

        System.out.println("Ders  :\t" + c3.name + "\nKod   :\t" + c3.code + "\nÖnek  :\t" + c3.prefix);
        c3.printTeacher();
        System.out.println("Not   :\tBu derste sözlü notunun etkisi %" + c3.note + " olacaktır.");
        System.out.println();

        // ArrayList ile dersleri toplu yazdırma
        System.out.println("DERSLER:");
        System.out.println("========");
        for(int i = 0; i < Course.courses.size(); i++) {
            System.out.println("Ders:\t" + Course.courses.get(i).prefix + "\t(" + Course.courses.get(i).code + ") " + Course.courses.get(i).name);
            System.out.println("Öğr.:\t" + Course.courses.get(i).teacher.mpno + "\t" + Course.courses.get(i).teacher.name + " (" + Course.courses.get(i).teacher.branch + ")");
            System.out.println("Not :\t" + "%" + Course.courses.get(i).note + "\tSözlü notu etkisi");
            System.out.println();
        }

        // Öğrenci notlarını yazdırma
        System.out.println(s1.notes[0][0] + "\t" + s1.notes[0][1] + "\t" + s1.notes[1][0] + "\t" + s1.notes[1][1] + "\t" + s1.notes[2][0] + "\t" + s1.notes[2][1]);
        System.out.println(s2.notes[0][0] + "\t" + s2.notes[0][1] + "\t" + s2.notes[1][0] + "\t" + s2.notes[1][1] + "\t" + s2.notes[2][0] + "\t" + s2.notes[2][1]);
				/*s1.printNote(c1);
				s1.printNote(c2);
				s1.printNote(c3); deneme amacli yazilmistir.
				s2.printNote(c1);
				s2.printNote(c2);
				s2.printNote(c3);*/
        System.out.println(s1.name + "\tnot ortalaması: \t" + s1.calcAverage());
        System.out.println(s2.name + "\tnot ortalaması: \t" + s2.calcAverage());
    }
}

class Course {
    // Kursun özellikleri: Adı, kodu, öneki, sözlü notunun dönem notuna % etkisi (int note), öğretmeni
    String name;
    String code;
    String prefix;
    int note; // Sözlü notu % ağırlık (sözlü notunun ortalamaya % olarak etkisi: Örn. 20 girilirse %20 hesaplanacak.
    // Not ağırlık oranı kurs objesi oluştururken girilecek, notlar öğrenci objesi oluştururken öğrenciye özel girilecek.
    Teacher teacher;
    // Obje oluşturmaya ek olarak kursları bir ArrayList'e de kaydediyoruz. Bu sayede ArrayList indexini kullanarak çağırabileceğiz.
    static ArrayList<Course> courses = new ArrayList<Course>();

    // Obje oluştururken constructor ile kurs bilgilerini giriyoruz: ad, kod, prefix, not ağırlık oranı %
    // Obje oluştururken kursun öğretmenini girmiyoruz. Onu sonradan derse addTeacher() metodu ile atıyoruz.
    public Course(String name, String code, String prefix, int note) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = note;
        courses.add(this);
    }

    // Kurs objesine addTeacher metoduyla öğretmen ataması yapıyoruz.
    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    // Kurs objesinin printTeacher metoduyla öğretmenini yazdırıyoruz.
    public void printTeacher() {
        System.out.println("Öğr.  :\t" + teacher.mpno + " " + teacher.name + " (" + teacher.branch + " Öğretmeni)");
    }
}

class Teacher {
    // Öğretmenin özellikleri: Adı, branşı, numarası
    String name;
    String branch;
    int mpno;

    // Obje oluştururken constructor ile öğretmen bilgilerini giriyoruz: ad, branş, no
    Teacher(String name, String branch, int mpno) {
        this.name = name;
        this.branch = branch;
        this.mpno = mpno;
    }
}

class Student {
    // Öğrencinin özellikleri: Adı, no, aldığı dersler (course1, course2, course3), notları, ortalaması, geçip geçmediği
    String name;
    int stuNo;
    Course course1, course2, course3;
    int[][] notes = new int[3][3]; // 3 ders için yazılı ve sözlü notlarının girileceği array ekledik. Son indexe hesaplanan nihai not girilecek.
    // Bu iki boyutlu dizinin ilk boyutunda notes[burası][] örencinin aldığı dersin ArrayList içindeki index bilgisi var. 0, 1, 2 olabiliyor.
    // İlk boyut 3 ders için 3 adet. Yani notes[3][]
    // Dizinin ikinci boyutunda notes[][burası] öğrencinin o ders için aldığı notlar var.
    // Üç ders için ayrı ayrı olmak üzere, 3 not bilgisi giriliyor: yazılı, sözlü, nihai not
    // Yani notes[][3]
    /*
     * notes[0][0] -----> courses ArrayList'te 0 indexindeki dersin yazılı notu
     * notes[0][1] -----> courses ArrayList'te 0 indexindeki dersin sözlü notu
     * notes[0][2] -----> courses ArrayList'te 0 indexindeki dersin nihai notu (hesaplanan not)
     * notes[1][0] -----> courses ArrayList'te 1 indexindeki dersin yazılı notu
     * notes[1][1] -----> courses ArrayList'te 1 indexindeki dersin sözlü notu
     * notes[1][2] -----> courses ArrayList'te 1 indexindeki dersin nihai notu
     * notes[2][0] -----> courses ArrayList'te 2 indexindeki dersin yazılı notu
     * notes[2][1] -----> courses ArrayList'te 2 indexindeki dersin sözlü notu
     * notes[2][2] -----> courses ArrayList'te 2 indexindeki dersin nihai notu
     */
    int average;
    boolean isPass;

    // Obje oluştururken constructor ile öğrenci bilgilerini giriyoruz: ad, no, aldığı dersler
    Student(String name, int stuNo, Course course1, Course course2, Course course3) {
        this.name = name;
        this.stuNo = stuNo;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
    }

    // Dersin yazılı ve sözlü notlarını giriyoruz.
    // Not girerken ders, yazılı notu, sözlü notu gönderilir.
    // Burada courseFinder(course) dikkat edilirse notes arrayinin ilk boyutunun indexi yerinde yazıyor. Yani aslında bir int değer döndürüyor.
    // Not girerken gönderdiğimiz ders bilgisiyle courseFinder metodunda, o dersin courses ArrayList'indeki indexini buluyoruz ve döndürüyoruz.
    // Böylece notes[][] arrayi her ders için yazılı ve sözlü notlarını barındırıyor.
    public void addBulkExamNote(Course course, int noteWritten, int noteOral) {
        this.notes[courseFinder(course)][0] = noteWritten;
        this.notes[courseFinder(course)][1] = noteOral;
    }

    // Öğrencinin 3 derse göre not ortalamasını hesaplıyoruz.
    public int calcAverage() {
        return (notes[0][2] + notes[1][2] + notes[2][2]) / 3;
    }

    // Hesaplanan son not ile öğrencinin dersi geçip geçmediğine bakıyoruz.
    public void isPass(int latestNote) {
        if(latestNote >= 50) {
            System.out.println("Öğrenci dersten geçmiştir.");
        }
        else {
            System.out.println("Öğrenci dersi tekrar alacaktır.");
        }
    }

    // Verilen ders için öğrencinin son notunu hesaplıyoruz.
    // Metoda gönderilen course için, courseFinder metodunda o dersin courses ArrayList'indeki indexini buluyoruz.
    // Ders notunu soruda verildiği şekilde hesaplıyoruz. (Sözlü notu * sözlü notunun etki yüzdesi + yazılı notu * yazılı notunun etki yüzdesi)
    // notes[ders][2] indexine kaydediyoruz.
    public void printNote(Course course) {
        notes[courseFinder(course)][2] = (notes[courseFinder(course)][0] * (100 - course.note) / 100) + (notes[courseFinder(course)][1] * course.note / 100);
        System.out.println(stuNo + "\t" + name + "\t" + course.name + "\tdersi dönem notu:\t" + notes[courseFinder(course)][2]);
        // Nihai nota göre öğrencinin o dersten geçip geçmediğine bakıyoruz.
        isPass(notes[courseFinder(course)][2]);
    }

    // Girilen dersin ArrayList'teki indexini döndüren metot ekledik.
    // Kursları obje obje oluştururken ek olarak da bir ArrayList'e eklemiştik. Bunu, kurslara bu ArrayList'ten bir index no atamak için kullanıyoruz.
    // Her dersin 0'dan başlayan bir index değeri oluyor. Böylece bu indexi notes[burası][] arrayinde kullanarak her dersin notlarını bir diziye kaydedebiliyoruz.
    private int courseFinder(Course course) {
        return Course.courses.indexOf(course); // Metodu çağırırken gönderilen ders objesi (örn c1)'nin courses ArrayList'indeki indexi.
    }
}
