package org.example.task2_3;

import java.util.Arrays;

public class Main23 {
    public static void main() {
        int[] someArray1 = new int[]{2, 0, 2, 3, 4};
        int[] someArray2 = new int[]{2, 2, 0, 0};
        int[] someArray3 = new int[]{1, 0, 3, 5, 0};
        showHasTwoAdjacentZeroItems(someArray1);
        showHasTwoAdjacentZeroItems(someArray2);
        showHasTwoAdjacentZeroItems(someArray3);

    }

    private static Boolean hasTwoAdjacentZeroItems(int[] array) {
        boolean zeroItems = false;
        int zeroPoint = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (i - zeroPoint == 1) {
                    zeroItems = true;
                    break;
                } else {
                    zeroPoint = i;
                    zeroItems = false;
                }
            }
        }
        return zeroItems;
    }

    private static void showHasTwoAdjacentZeroItems(int[] array) {
        System.out.println("hasTwoAdjacentZeroItems(" + Arrays.toString(array) + ") → " + hasTwoAdjacentZeroItems(array));
    }
}
