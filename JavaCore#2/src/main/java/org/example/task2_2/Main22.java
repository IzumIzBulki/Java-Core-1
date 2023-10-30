package org.example.task2_2;

import java.text.MessageFormat;
import java.util.Arrays;

public class Main22 {
    public static void main() throws Exception {
        int[] someArray1 = new int[]{2, 1, 2, 3, 4};
        int[] someArray2 = new int[]{2, 2, 0};
        int[] someArray3 = new int[]{1, 3, 5};
        showResultDifMaxMin(someArray1);
        showResultDifMaxMin(someArray2);
        showResultDifMaxMin(someArray3);
    }

    private static void showResultDifMaxMin(int[] array) throws Exception {
        System.out.println(MessageFormat.format("MAX({0} - MIN({1}) = {2}",
                Arrays.toString(array), Arrays.toString(array), difMaxMin(array)));
    }

    private static int difMaxMin(int[] array) throws Exception {
        if (array.length == 0) {
            throw new Exception("Array can not be empty");
        } else if (array.length == 1) {
            return 0;
        } else {
            int minValue = array[0];
            int maxValue = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] < minValue) {
                    minValue = array[i];
                }
                if (array[i] > maxValue) {
                    maxValue = array[i];
                }
            }
            return maxValue - minValue;
        }
    }
}
