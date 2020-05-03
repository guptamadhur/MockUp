package web.app.madhurgupta.Practice.String.Palindrome;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

Input : geeksogeeks {Check if the string can be made palindrome or not}
Output: True
 */

public class RearrangePalindrome {
    public static void main(String[] args) {
        System.out.println("geeksogeeks: "+checkString("geeksogeeks"));
        System.out.println("wwwa: "+checkString("wwwa"));
    }
    static boolean checkString(String str){
        int[] count=new int[26];
        int odd=0;
        str =str.toLowerCase();
        for(int i=0;i< str.length();i++){
            count[(int) str.charAt(i)-97]++;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]%2 == 1){
                odd++;
            }
            if(odd > 1)
                return false;
        }
        return true;
    }
}
