package web.app.madhurgupta.JavaPractice.Others;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

public class MyThread extends Thread {
}

class ThreadClass{
    public static void main(String args[]){
        System.out.println(Thread.currentThread().isDaemon());
        //Thread.currentThread().setDaemon(true);
        MyThread myThread=new MyThread();
        System.out.println(myThread.isDaemon());
        myThread.setDaemon(true);
        System.out.println(myThread.isDaemon());
        System.out.println(Thread.currentThread().getThreadGroup());
        System.out.println(Thread.currentThread().getThreadGroup().getParent());
    }
}
