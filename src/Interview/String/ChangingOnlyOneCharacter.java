/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

Convert the string into palindrome string by changing only one character.
        Given a string str. Check if it is possible to convert the string into palindrome string by changing only one character.

        Examples:

        Input : str = "abccaa"
        Output : Yes
        We can change the second last character
        i.e. 'a' to 'b' to make it palindrome string

        Input : str = "abbcca"
        Output : No
        We can not convert the string into palindrome
        string by changing only one character.
*/

public class ChangingOnlyOneCharacter {
    static boolean checkPalindrome(String str){
        int len=str.length();
        int count=0;

        for(int i=0; i<len/2;i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                ++count;
        }
            return (count<=1);
    }

    public static void main(String[] args) {
        String str = "abccaa";
        if (checkPalindrome(str))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
