package web.app.madhurgupta.JavaPractice.Others;

import java.util.Scanner;

class Solution1 {
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        long nr = scan.nextLong();
        long dr = scan.nextLong();
        //  System.out.println(nr+ " "+dr);
        //  System.out.println(isCommonDivisor(nr, dr));
        if (isCommonDivisor(nr, dr) == 1) {
            printEgyptian(nr, dr);
        }
    }

    private static int isCommonDivisor(long a, long b) {
        long n = gcd(a, b);

        // Count divisors of n.
        int result = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            // if 'i' is factor of n
            if (n % i == 0) {
                // check if divisors are equal
                if (n / i == i)
                    result += 1;
                else
                    result += 2;
            }
        }
        return result;
    }

    private static long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }


    static void printEgyptian(long nr, long dr) {
        // If either numerator or
        // denominator is 0
        if (dr == 0 || nr == 0) {
            return;
        }

        if (dr % nr == 0) {
            System.out.print(dr / nr);
            return;
        }

        if (nr % dr == 0) {
            System.out.print(nr / dr);
            return;
        }

        if (nr > dr) {
            System.out.print(nr / dr + " + ");
            printEgyptian(nr % dr, dr);
            return;
        }

        long n = dr / nr + 1;
        System.out.print(n + " ");

        printEgyptian(nr * n - dr, dr * n);

    }
}