package web.app.madhurgupta.Practice.String.Reverse;

import java.text.ParseException;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

public class ReverseString {
    
    static String rev(String str) {
        if (null == str || str.length() <= 1) {
            return str;
        }
        return rev(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(rev("Congratulations"));
    }
}
