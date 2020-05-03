package web.app.madhurgupta.JavaPractice.Others;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Java program to find LCM of two numbers.
class Test {
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println("LCM of " + a + " and " + b + " is " + lcm(a, b));
        if (primeFactors(lcm(a, b)) % 2 != 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    static int primeFactors(int n) {
        {
            Set<Integer> set = new HashSet<Integer>();
            while (n % 2 == 0) {
                set.add(2);
                n /= 2;

            }

            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                while (n % i == 0) {
                    set.add(i);

                    n /= i;
                }
            }

            if (n > 2) {
                set.add(n);
            }
            return set.size();

        }
    }
}

