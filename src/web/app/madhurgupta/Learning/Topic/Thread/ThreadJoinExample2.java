package web.app.madhurgupta.Learning.Topic.Thread;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: MockUp
# Created on: 03-05-2020 17:52
*/

public class ThreadJoinExample2 implements Runnable {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ThreadJoinExample2());
        //t.start();

        // Waits for 1000ms this thread to die.
        Thread a = new Thread(new A());
        Thread b = new Thread(new B());
        a.start();
        b.join();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread t = Thread.currentThread();
            System.out.println("Current thread: " + t.getName() + t.isAlive());
        }
    }
}

class A implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread t = Thread.currentThread();
            System.out.println("A: " + t.getName() + t.isAlive());
        }
    }
}

class B implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread t = Thread.currentThread();
            System.out.println("B: " + t.getName() + t.isAlive());
        }
    }
}
