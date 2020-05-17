package web.app.madhurgupta.Practice.String.KNP;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: MockUp
# Created on: 03-05-2020 23:55
# O(m*n)
*/

public class Naive {
    public static String pattern, magazine;

    public static void main(String[] args) {
        Naive obj = new Naive();
//        pattern = "fihjjjjei";
//        magazine = "hjibagacbhadfaefdjaeaebgi";
        pattern ="abcdabce";
        magazine ="abcdabczabcqabcdabce";
        System.out.println("String are -> \npattern: "+pattern+"  magazine: "+magazine);
        System.out.println(obj.hasSubstring(magazine.toCharArray(), pattern.toCharArray()));
    }

    /**
     * Slow method of pattern matching
     */
    public boolean hasSubstring(char[] text, char[] pattern) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = 0;
                k++;
                i = k;
            }
        }
        return j == pattern.length;
    }
}
