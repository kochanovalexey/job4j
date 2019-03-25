package ru.job4j.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Class Удаление дубликатов в массиве
 * @author akochanov
 * @since 25.03.2019
 * @version 1
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int arrayLength = array.length;
        for (int out = 0; out < arrayLength; out++) {
            for (int in = out + 1; in < arrayLength; in++) {
                if (array[out] == array[in]) {
                    array[in] = array[arrayLength - 1];
                    arrayLength--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, arrayLength);
    }
}
