package web.app.madhurgupta.Practice.String.Palindrome;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

Minimum cost to convert string into palindrome

Input : abcdef
Output : 6
Explanation: replace 'a', 'b' and
'c' => cost= 1 + 2 + 3 = 6

Input : aba
Output : 0
*/

class MinCostToMakePalindrome {
    // Function to return cost
    static int cost(String str) {
        // length of string
        int len = str.length();

        // Iterate from both sides of string.
        // If not equal, a cost will be there
        int res = 0;
        for (int i = 0, j = len - 1; i < j; i++, j--)
            if (str.charAt(i) != str.charAt(j))
                res += Math.min(str.charAt(i), str.charAt(j)) - 'a' + 1;

        return res;
    }

    // Driver code
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(cost(str));
    }
}