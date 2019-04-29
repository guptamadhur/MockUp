/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

Minimum cost to construct a string

Given a string s (containing lowercase letters only), we have to find the minimum cost to construct the given string.
The cost can determined using the following operations:
1. Appending a single character cost 1 unit
2. A sub-string of new string(intermediate string) can be appended without any cost

Note* Intermediate string is the string formed so far.

Input : "geks"
Output : cost: 4
Explanation:
appending 'g' cost 1, string "g"
appending 'e' cost 1, string "ge"
appending 'k' cost 1, string "gek"
appending 's' cost 1, string "geks"
Hence, Total cost to construct "geks" is 4

Input :  "abab"
Output : cost: 2
Explanation:
Appending 'a' cost 1, string "a"
Appending 'b' cost 1, string "ab"
Appending  "ab" cost nothing as it
is substring of intermediate.
Hence, Total cost to construct "abab" is 2
*/

public class MinCostToConstructString {

    static int minCost(String str){
        int cost=0;

        boolean[] letter= new boolean[26];
        str=str.replaceAll("//s","").toLowerCase();
        char[]st = str.toCharArray();
        for(int i=0;i<st.length;i++){
            letter[(int) st[i]-97]=true;
        }
        for(int i=0;i<letter.length;i++){
            if(letter[i]){
                cost++;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println("Min Cost to Construct String is:"+ minCost("HelloWorldThisisJava"));
    }
}
