package web.app.madhurgupta.Practice.String.LCS;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: MockUp
# Created on: 03-05-2020 23:16
*/

public class LCS_Recursion {
    static char A[]= new char[]{'b','d','\0'},B[]= new char[]{'a','b','c','d','\0'};
    public static void main(String[] args) {
        LCS_Recursion ob = new LCS_Recursion();
        System.out.println(ob.LCS(0,0));
    }
    int LCS(int i, int j){
        if(A[i]=='\0' || B[j]=='\0'){
            return 0;
        }else if(A[i]==B[j]){
            System.out.println(A[i]);
            return 1+LCS(i+1,j+1);
        }else{
            return Math.max(LCS(i+1,j),LCS(i,j+1));
        }
    }
}
