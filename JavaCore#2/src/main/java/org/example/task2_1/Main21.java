package org.example.task2_1;

import java.util.Arrays;

public class Main21 {
    public static void main() {
        int[] someArray1 = new int[]{2, 1, 2, 3, 4};
        int[] someArray2 = new int[]{2, 2, 0};
        int[] someArray3 = new int[]{1, 3, 5};
        showResultCountEvens(someArray1);
        showResultCountEvens(someArray2);
        showResultCountEvens(someArray3);
    }

    public static int countEvens(int[] array) {
        int counter = 0;
        for (int item : array) {
            if (item % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static void showResultCountEvens(int[] array) {
        System.out.println("countEvens(" + Arrays.toString(array) + ") → " + countEvens(array));
    }
}
