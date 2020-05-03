package web.app.madhurgupta.Interview.JustDial;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp

Input Array: 54,546,548,60
Output: 6054854654
 */

import java.util.Arrays;
import java.util.Comparator;

class BiggestNumber {

    static void printLargest(int[] nums){

        String[] arr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }
        System.out.print(sb.toString());
    }

    // driver program
    public static void main (String[] args) {
        int[] arr= new int[]{54,546,548,60};
        //output should be 6054854654
        printLargest(arr);
    }
}
