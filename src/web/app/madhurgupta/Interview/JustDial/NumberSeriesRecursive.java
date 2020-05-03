package web.app.madhurgupta.Interview.JustDial;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

{4,7,8,2,1}             4  7  8  2  1
                         3  1 -6 -1
                          -2 -7  5
                            -5  12
                              17
*/

public class NumberSeriesRecursive {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 8, 2, 1};
        System.out.println(series(arr));
    }

    public static int series(int[] arr) {
        if (arr.length <= 1)
            return arr[0];
        return series(calculate(arr));
    }
    private static int[] calculate(int[] arr) {
        int[] newlist = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            int a = i + 1;
            int val = arr[a] - arr[i];
            newlist[i] = val;
        }
        return newlist;
    }
}