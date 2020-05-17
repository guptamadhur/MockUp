package web.app.madhurgupta.Practice.Algorithm;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: MockUp
# Created on: 16-05-2020 16:42
*/

//Max Contiguous Subarray Sum - Cubic Time To Kadane's Algorithm (Maximum Subarray)

public class Kadanes_Algorithm {
    public static void main(String[] args) {
        Kadanes_Algorithm ob = new Kadanes_Algorithm();
        System.out.println(ob.kadanes(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));//6
        System.out.println(ob.kadanes(new int[]{1, -2, 3, -2})); //3
        System.out.println(ob.maxSubarraySumCircular(new int[]{1, -2, 3, -2})); //3
        System.out.println(ob.maxSubarraySumCircular(new int[]{-3, -2, -1})); //-1
    }

    public int maxSubarraySumCircular(int[] A) {
        int maxv;
        int[] max = new int[A.length];
        max[0] = A[0];
        maxv = max[0];
        for (int i = 1; i < A.length; i++) {
            max[i] = Math.max((max[i - 1] + A[i]), A[i]);
            if (max[i] >= maxv) {
                maxv = max[i];
            }
        }
        return maxv;
    }

    public int kadanes(int[] A) {
        int max = Integer.MIN_VALUE, cur1 = 0, total = 0;
        for (int value : A) {
            cur1 += value;
            max = Math.max(max, cur1);
            cur1 = Math.max(cur1, 0);

            total += value;
        }
        return max < 0 ? max : Math.max(max, total);
    }
}
