package web.app.madhurgupta.JavaPractice.Others;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

public class ThreadJoinExample {

    volatile int status=1;
    public static void main(String[] args) {

        ThreadJoinExample p = new ThreadJoinExample();

        A1 a=new A1(p);
        B1 b=new B1(p);
        C1 c=new C1(p);

        a.start();
        b.start();
        c.start();
    }
}

class A1 extends Thread{
    ThreadJoinExample p1;

    A1(ThreadJoinExample p){
        this.p1 = p;
    }

    @Override
    public void run() {

        try{
            synchronized (p1) {

                for (int i = 0; i < 10; i++) {

                    while(p1.status!=1){
                        p1.wait();
                    }

                    System.out.print("A ");
                    p1.status = 2;
                    p1.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 1 :"+e.getMessage());
        }

    }

}

class B1 extends Thread{

    ThreadJoinExample p2;

    B1(ThreadJoinExample p2){
        this.p2 = p2;
    }

    @Override
    public void run() {

        try{
            synchronized (p2) {

                for (int i = 0; i < 10; i++) {

                    while(p2.status!=2){
                        p2.wait();
                    }

                    System.out.print("B ");
                    p2.status = 3;
                    p2.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 2 :"+e.getMessage());
        }

    }
}

class C1 extends Thread{

    ThreadJoinExample p3;

    C1(ThreadJoinExample p){
        this.p3 = p;
    }

    @Override
    public void run() {

        try{
            synchronized (p3) {

                for (int i = 0; i < 10; i++) {

                    while(p3.status!=3){
                        p3.wait();
                    }

                    System.out.print("C ");
                    p3.status = 1;
                    p3.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 3 :"+e.getMessage());
        }

    }
}
