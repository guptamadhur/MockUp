package web.app.madhurgupta.Practice.PatternQuestion;
import java.util.Scanner;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

         1
        121
       12321
      1234321
       12321
        121
         1
*/

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int n= scanner.nextInt();
        for(int i=1;i<=n;i++){
            for(int k=0;k<=(n-i);k++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int j=i-1;j>0;j--){
                System.out.print(j);
            }
            System.out.println("");
        }
        for(int i=1;i<=n;i++){
            for(int k=0;k<=i;k++){
                System.out.print(" ");
            }
            for(int j=1;j<=n-i;j++){
                System.out.print(j);
            }
            for(int j=n-i-1;j>0;j--){
                System.out.print(j);
            }
            System.out.println("");
        }
    }
}
