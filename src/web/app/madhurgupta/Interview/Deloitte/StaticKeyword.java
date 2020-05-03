package web.app.madhurgupta.Interview.Deloitte;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

class A {
    public static void display() {
        System.out.println("ABC");
    }
}

class B extends A {
    public static void display() {
        System.out.println("XYZ");
    }
}

class StaticKeyword {
    public static void main(String[] args) {
        A obj = new B();
        obj.display();
        A.display();
        B.display();
    }
}
