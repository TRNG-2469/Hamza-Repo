package com.revature.week2;

public class MathUtils {
    public static long factorial(int n){
        int retval = 1;
        for (int i = 1; i <= n; i++){
            retval *= i;
        }
        return retval;
    }
    public static boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static double celsiusToFahrenheit(double celsius){
        return (celsius * 9/5) + 32;
    }
    public static int findMax(int[] arr){
        if (arr == null || arr.length == 0) {
            System.out.println("Warning: array is null or empty");
            return 0;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static double findMax(double[] arr){
        if (arr == null || arr.length == 0) {
            System.out.println("Warning: array is null or empty");
            return 0;
        }
        double max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Is 7 prime? " + isPrime(7));
        System.out.println("0°C to Fahrenheit: " + celsiusToFahrenheit(0));
        System.out.println("Max of [3, 7, 2, 9, 1]: " + findMax(new int[]{3, 7, 2, 9, 1}));
        System.out.println("Max of [1.5, 3.2, 2.8, 4.1]: " + findMax(new double[]{1.5, 3.2, 2.8, 4.1}));
    }
}
