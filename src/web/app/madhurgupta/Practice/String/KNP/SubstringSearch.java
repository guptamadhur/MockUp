package web.app.madhurgupta.Practice.String.KNP;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: MockUp
# Created on: 04-05-2020 00:01
# Do pattern matching using KMP algorithm
#
# Runtime complexity - O(m + n) where m is length of text and n is length of pattern
# Space complexity - O(n)
*/

public class SubstringSearch {
    public static void main(String[] args) {

        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        SubstringSearch ss = new SubstringSearch();
        System.out.println("Input Strings -> \nString: " + str + " pattern:" + subString);
        System.out.print(ss.KMP(str.toCharArray(), subString.toCharArray()));
    }

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private int[] computeTemporaryArray(char[] pattern) {
        int[] lps = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    public boolean KMP(char[] text, char[] pattern) {

        int[] lps = computeTemporaryArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j == pattern.length;
    }
}
