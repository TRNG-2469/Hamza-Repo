import java.util.Arrays;

public class PrimitivePractice {
    public static void main(String[] args) {
        boolean bool = true;
        byte by = 0;
        char c1 = 'a';
        short s = 1;
        int i = 200000;
        float f = 1.234f;
        long l = 9223372036854775807L;
        double d = 1.234;
        System.out.println("boolean = " + bool);
        System.out.println("byte = " + by);
        System.out.println("char = " + c1);
        System.out.println("short = " + s);
        System.out.println("int = " + i);
        System.out.println("float = " + f);
        System.out.println("long = " + l);
        System.out.println("double = " + d);

        byte smallVal = 50;
        int largeVal = smallVal;

        double decimalVal = 99.9;
        System.out.println("decimalVal = " + decimalVal);
        int truncatedVal = (int) decimalVal;
        System.out.println("truncatedVal = " + truncatedVal);

        int a  = 10;
        int b = a;
        b = 20;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int[] firstArray = new int[]{10, 20, 30};
        int[] secondArray = firstArray;
        secondArray[0] = 999;
        System.out.println("firstArray = " + Arrays.toString(firstArray));
        System.out.println("secondArray = " + Arrays.toString(secondArray));
        /**
         * The reason by changing secondArray affected firstArray was mainly
         * array are stored by reference (they copy the address on memory) and both
         * firstArray and secondArray variables point to the same reference in
         * memory. So changing the secondArray, the firstArray also saw the change
         * and that's why its value changed too.
         */
    }
}
