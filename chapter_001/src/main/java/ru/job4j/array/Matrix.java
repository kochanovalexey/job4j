package ru.job4j.array;

/**
 * Class Таблица умножения.
 * @author akochanov
 * @since 25.03.2019
 * @version 1
 */
public class Matrix {
    /**
     * Метод возращающий таблицу умножения в массиве
     * @param size - размер
     * @return - таблица умножения в массиве
     */
    int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
