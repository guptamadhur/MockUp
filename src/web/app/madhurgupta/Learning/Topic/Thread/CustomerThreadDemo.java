package web.app.madhurgupta.Learning.Topic.Thread;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
# Normal Thread class is not safe as it may give same ID to multiple threads
 */

public class CustomerThreadDemo {
    public static void main(String[] args) {
        CustomerThread thread = new CustomerThread("Thread 1");
        CustomerThread thread1 = new CustomerThread("Thread 2");
        CustomerThread thread2 = new CustomerThread("Thread 3");
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class CustomerThread extends Thread {
    static Integer custId = 0;
    private static final ThreadLocal t1 = new ThreadLocal() {
        protected Integer initialValue() {
            return ++custId;
        }
    };

    CustomerThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " Customer Thread ID: " + t1.get());
    }
}

//        Thread 2 Customer Thread ID: 1
//        Thread 3 Customer Thread ID: 2
//        Thread 1 Customer Thread ID: 1
