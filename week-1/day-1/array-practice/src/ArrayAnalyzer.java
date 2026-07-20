import java.util.Arrays;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        int range = 100;
        int min = 1;
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * range) + min;
        }
        System.out.println("Array " + "= " + Arrays.toString(arr));
        //Sum
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum =+ arr[i];
        }
        System.out.println("SUM" + " = " + sum);
        //Average
        double avg = 0;
        int avgSum = 0;
        for (int i = 0; i < arr.length; i++){
            avgSum =+ arr[i];
        }
        avg = avgSum / arr.length;
        System.out.println("Average " + "= " + avg);
        //Minimum
        int minVal = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (minVal > arr[i]){
                minVal = arr[i];
            }
        }
        System.out.println("Minimum " + "= " + minVal);
        //Maximum
        int maxVal = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (maxVal < arr[i]){
                maxVal = arr[i];
            }
        }
        System.out.println("Maximum " + "= " + maxVal);
    }
}
