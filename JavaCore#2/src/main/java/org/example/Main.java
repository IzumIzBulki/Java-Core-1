package org.example;

import org.example.task2_1.Main21;
import org.example.task2_2.Main22;
import org.example.task2_3.Main23;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("""
                1. Написать метод, возвращающий количество чётных элементов массива.
                countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0:
                """);
        Main21.main();
        System.out.println();
        System.out.println("""
                2. Написать функцию, возвращающую разницу между самым большим
                и самым маленьким элементами переданного не пустого массива:
                """);
        Main22.main();
        System.out.println();
        System.out.println("""
                3. Написать функцию, возвращающую истину,
                если в переданном массиве есть два соседних элемента, с нулевым значением:
                """);
        Main23.main();
    }
}
