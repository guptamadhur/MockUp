package web.app.madhurgupta.Practice.DynamicProgramming;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: MockUp Java
# Created on: 28-09-2020 14:13
*/

/*
    Link: https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/avatar-and-his-quest-d939b13f/
    You have to travel to different villages to make some profit.
    In each village, you gain some profit. But the catch is, from a particular village i,
    you can only move to a village j if and only if  and the profit gain from village j is a multiple
    of the profit gain from village i.

    You have to tell the maximum profit you can gain while traveling.

    Input format

    The first line contains a single integer N denoting the total number of villages.
    The second line contains N space-separated integers, each denoting the profit gain  from village i.
    Output format

    Print the maximum profit you can gain.

    Constraints
    1 <= N <=10^3
    0 <= P <= 10^5

    SAMPLE INPUT
    6
    1 2 3 4 9 8
    SAMPLE OUTPUT
    15
    Explanation
    The maximum profit 15 can be achieved by following the path with villages at index (0, 1, 3, 5) with profit gain (1, 2, 4, 8).
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Profit_Maximization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
//        int n = Integer.parseInt(br.readLine().trim());
//        String[] arr_p = br.readLine().split(" ");
//        int[] p = new int[n];
//        for (int i_p = 0; i_p < arr_p.length; i_p++) {
//            p[i_p] = Integer.parseInt(arr_p[i_p]);
//        }
//        wr.println(solve(p));
        wr.println(solve(new int[]{1, 2, 3, 4, 9, 8}));
        wr.close();
        br.close();
    }

    static int solve(int[] p) {
        int returningProfit = 0;
        for (int x = p.length - 1; x >= 0; x--) {
            int currentVillage = 0;
            int currentProfitGain = 0;
            int runningProfit = 0;

            for (int i = x; i >= 0; i--) {
                if (i == x) {
                    currentVillage = i;
                    runningProfit += p[i];
                    currentProfitGain = p[i];
                }
                if (currentVillage > i && currentProfitGain % p[i] == 0) {
                    runningProfit += p[i];
                    currentProfitGain = p[i];
                    currentVillage = i;
                }
            }
            if (returningProfit < runningProfit) {
                System.out.println(x + " returningProfit: " + returningProfit + " runningProfit: " + runningProfit);
                returningProfit = returningProfit < runningProfit ? runningProfit : returningProfit;
            }
        }
        return returningProfit;
    }
}
