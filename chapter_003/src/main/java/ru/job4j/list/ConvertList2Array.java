package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Class Класс, конвертирующий ArrayList в двухмерный массив
 *
 * @author akochanov
 * @version 1
 * @since 03.06.2019
 */
public class ConvertList2Array {
    /**
     * Метод, конвертирующий ArrayList в двухмерный массив.
     * @param list - входящий ArrayList
     * @param rows - число строк
     * @return - двумерный массив
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int firstIndex = 0;
        int secondIndex = 0;
        for (int value : list) {
            array[firstIndex][secondIndex] = value;
            if (secondIndex == cells - 1) {
                firstIndex++;
                secondIndex = 0;
            } else {
                secondIndex++;
            }
        }
        return array;
    }

    /**
     * Метод, конвертирующий List<int[]> в List<Integer>
     * @param list - входящий List<int[]>
     * @return - List<Integer>
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> listInteger = new ArrayList<>();
        for (int[] array : list) {
            for (int value : array) {
                listInteger.add(value);
            }
        }
        return listInteger;
    }
}
