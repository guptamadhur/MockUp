package com.guptamadhur.Interview.JustDial;

import java.util.Scanner;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

           1
          123
         12345
        1234567
       123456789
        1234567
         12345
          123
           1
          */

public class DiamondNumberPattern
{
    public static void main(String args[])
    {
        int n, i, j, space = 1;
        System.out.print("Enter the number of rows: ");
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        space = n - 1;
        for (j = 1; j <= n; j++)
        {
            for (i = 1; i <= space; i++)
            {
                System.out.print(" ");
            }
            space--;
            for (i = 1; i <= 2 * j - 1; i++)
            {
                System.out.print(i);
            }
            System.out.println("");
        }
        space = 1;
        for (j = 1; j <= n - 1; j++)
        {
            for (i = 1; i <= space; i++)
            {
                System.out.print(" ");
            }
            space++;
            for (i = 1; i <= 2 * (n - j) - 1; i++)
            {
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}