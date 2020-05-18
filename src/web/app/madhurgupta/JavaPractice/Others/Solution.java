package web.app.madhurgupta.JavaPractice.Others;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String user_input = scan.nextLine();
        String[] stringsArray = user_input.split(" ");
        int len = Integer.parseInt(stringsArray[0]);
        int x = Integer.parseInt(stringsArray[1]);

        String in = scan.nextLine();
        String[] ar = in.split(" ");
        int[] intArray = new int[len];
        for (int i = 0; i < len; i++) {
            intArray[i] = Integer.parseInt(ar[i]);
            intArray[i] = check(intArray[i], x);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + intArray[i];
        }
        System.out.println(sum);
    }

    public static int check(int val, int x) {
        float y = val / x;
        return (int)myfun(y) * x;
    }

    private static double myfun(float y) {
        return y >= 0 ? Math.floor(y) : Math.ceil(y);
    }
}
