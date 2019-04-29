/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

Minimum number of characters to be replaced to make a given string Palindrome

Examples:

Input: str = "geeks"
Output: 2
geeks can be converted to geeeg to make it palindrome
by replacing minimum characters.

Input: str = "ameba"
Output: 1
We can get "abeba" or "amema" with only 1 change.
Among those two, "abeba" is lexicographically smallest
 */


public class MinCharacterToReplaceToMakePlaindrome {
    static void minCharactertoReplace(String str){
        int len=str.length();
        int steps=0;

        for(int i=0;i<len/2;i++){
            if(str.charAt(i) != str.charAt(len-i-1)){
                steps ++;

                if(str.charAt(i) < str.charAt(len-i-1)){
                    str = str.replace(str.charAt(len - i - 1),str.charAt(i));
                }else{
                    str = str.replace(str.charAt(i),str.charAt(len-i-1));
                }
            }
        }
        System.out.println("Min Characters to change:"+ steps);
    }

    public static void main(String[] args) {
        minCharactertoReplace("helloworld");
        minCharactertoReplace("ameba");
    }
}
