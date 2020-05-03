package web.app.madhurgupta.Practice.Debug;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

public class MainDebug implements Debuggable {
    int a = 100;
    String b = "Home";

    public static void main(String[] args) {
        MainDebug m = new MainDebug();
        System.out.println(m.debug());
    }
}