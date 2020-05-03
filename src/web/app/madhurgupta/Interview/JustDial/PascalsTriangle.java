package web.app.madhurgupta.Interview.JustDial;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

Pascal's triangle is an matrix of the binomial coefficients.
        The number of entries in every row increases by 1 starting from the first row having 1 entry
        and the second row having 2 entries and so on

          1
         1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
*/

public class PascalsTriangle {
    static int factorial(int n)
    {
        if (n == 0)
            return 1;

        return n*factorial(n-1);
    }

    static int ncr(int n,int r) {
        return factorial(n) / ( factorial(n-r) * factorial(r) );
    }
    public static void main(String args[]){
        System.out.println();
        int n, i, j;
        n = 4;

        for(i = 0; i <= n; i++) {
            for(j = 0; j <= n-i; j++){
                System.out.print(" ");
            }
            for(j = 0; j <= i; j++){
                System.out.print(" "+ncr(i, j));
            }
            System.out.println();
        }
    }
}