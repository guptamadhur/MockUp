package web.app.madhurgupta.Practice.String.LCS;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: MockUp
# Created on: 03-05-2020 23:17
*/

public class LCS_Dynamic_Programming {
    static char[] A = new char[]{'\0', 'b', 'd'};
    static char[] B = new char[]{'\0', 'a', 'b', 'c', 'd'};
    static int[][] LCS = new int[4][6];

    public static void main(String[] args) {
        LCS_Dynamic_Programming ob = new LCS_Dynamic_Programming();
        System.out.println(ob.LCSdynamic(3,5));
    }

    int LCSdynamic(int i, int j) {
        if(i==0|| j==0)
            return 0;
        if (A[i-1] == B[j-1]) {
            LCS[i][j] = 1 + LCS[i - 1][j - 1];
        } else {
            LCS[i][j] = Math.max(LCSdynamic(i - 1,j), LCSdynamic(i,j - 1));
        }
        return LCS[3][5];
    }
}
