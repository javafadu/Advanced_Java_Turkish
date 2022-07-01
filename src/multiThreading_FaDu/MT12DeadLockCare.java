package multiThreading_FaDu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MT12DeadLockCare {
    public static void main(String[] args) {
        Lock lock1=new ReentrantLock();
        Lock lock2=new ReentrantLock();
        Thread anneTh=new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flagKızım=false;
                boolean flagOglum=false;
                boolean doneKızım=false;
                boolean doneLOglum=false;
                while (true){

                    try {
                        if (!flagKızım){
                            flagKızım=lock1.tryLock();
                            if(flagKızım){
                                System.out.println("anne kızı yemege cıkardı..");
                            }
                        }
                        if (!flagOglum){
                            flagOglum=lock2.tryLock();
                            if(flagOglum){
                                System.out.println("anne oglu yemege cıkardı..");
                            }
                        }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }


                    }
                    finally {
                        if (flagKızım && !doneKızım){
                            lock1.unlock();
                            doneKızım=true;
                            System.out.println("anne kızını yemekten gönderdi...");

                        }
                        if (flagOglum && !doneLOglum){
                            lock2.unlock();
                            doneLOglum=true;
                            System.out.println("anne oglunu  yemekten gönderdi...");
                        }
                    }
                    if (flagKızım && flagOglum){
                        break;
                    }
                }
            }
        });
        Thread babaTh=new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flagKızım=false;
                boolean flagOglum=false;
                boolean doneKızım=false;
                boolean doneLOglum=false;
                while (true){

                    try {
                        if (!flagKızım){
                            flagKızım=lock1.tryLock();
                            if(flagKızım){
                                System.out.println("baba kızı yemege cıkardı..");
                            }
                        }
                        if (!flagOglum){
                            flagOglum=lock2.tryLock();
                            if(flagOglum){
                                System.out.println("baba oglu yemege cıkardı..");
                            }
                        }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }


                    }
                    finally {
                        if (flagKızım && !doneKızım){
                            lock1.unlock();
                            doneKızım=true;
                            System.out.println("baba kızını yemekten gönderdi...");

                        }
                        if (flagOglum && !doneLOglum){
                            lock2.unlock();
                            doneLOglum=true;
                            System.out.println("baba oglunu  yemekten gönderdi...");
                        }
                    }
                    if (flagKızım && flagOglum){
                        break;
                    }
                }
            }
        });
        anneTh.start();
        babaTh.start();
    }
}