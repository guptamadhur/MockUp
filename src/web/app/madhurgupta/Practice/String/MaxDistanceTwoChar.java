package web.app.madhurgupta.Practice.String;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

/*

Mettl Coding Test : Find the max. distance between two occurrences of a char in a string

Problem Statement:

Write a method to find the max. distance between two occurrences of a char in a string.
Distance is the no. of unique characters (excluding whitespaces and searched character) between two occurrences of the searched character.
Example 1:

SearchLetter(“my name is granar”, “a”);

Output : 7 (i.e. m,e,i,s,g,r,n)

Example 2:

SearchLetter(“the capital of minnesota is saint paul”, “y”);

Output : -1 (no. occurrence of “y”)

Example 3:

SearchLetter(“quick brown fox jumps over the lazy dog”, “a”);

Output : -1 (only 1 occurrence of “a”)

*/

public class MaxDistanceTwoChar {
    public static void main(String args[]) {
        String input[][] = { { "my name is granar", "a" }, { "the capital of minnesota is saint paul", "y" },
                { "quick brown fox jumps over the lazy dog", "a" } };
        for (int i = 0; i < input.length; i++) {
            int op = MaxDistanceTwoChar.getDistance(input[i][0], input[i][1]);
            System.out.println("Input:" + input[i][0] + " Key: " + input[i][1] + " o/p: " + op);
        }
    }

    static int getDistance(String input, String k) {
        int op = -1;
        if (input.isEmpty() || input.isBlank() || input.length() < 2 || k.length() != 1) {
            op = -1;
        } else {
            char ke = k.charAt(0);
            String searchString = input.replaceAll(" ", "");
            int firstIndex = searchString.indexOf(ke);
            int lastIndex = searchString.lastIndexOf(ke);

            int distance = lastIndex - firstIndex;
            if (distance > 0) {
                searchString = searchString.substring(firstIndex + 1, lastIndex - 1);
                String tempStr = "";
                for (char st : searchString.toCharArray()) {
                    if (tempStr.indexOf(st) == -1) {
                        tempStr += st;
                    }
                }
                // System.out.println("searchString: "+ searchString + " "+ tempStr + " "+
                // firstIndex + " "+ lastIndex + " " + input + " "+ ke + " " + distance);
                op = tempStr.length();
            }
        }
        return op;
    }
}
