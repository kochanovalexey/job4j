package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Класс, конвертирующий двумерный массив в List
 *
 * @author akochanov
 * @version 1
 * @since 04.06.2019
 */
public class ConvertMatrix2List {
    /**
     * Метод, конвертирующий двумерный массив в List
     * @param array - двумерный массив
     * @return - List
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] in : array) {
            for (int value : in) {
                list.add(value);
            }
        }
        return list;
    }
}
