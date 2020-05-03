package web.app.madhurgupta.Interview.Deloitte;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: MockUp
# Created on: 29-02-2020 22:22

Input: {1,2,3,4,5,6,7,8,9,10}
Output:
            1
           2 3
          4 5 6
         7 8 9 10
*/

public class PyramidTriangle {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length, count = 0;
        for (int i = 1; i < n / 2; i++) { //Number of lines
            for (int sp = n / 2 - i + 1; sp > 0; sp--) { //Space
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) { //Digits
                System.out.print(arr[count] + " ");
                count++;
            }
            System.out.println("");
        }
    }
}
