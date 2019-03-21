package ru.job4j.array;

/**
 * Class Класс, заполняющий массив числами, возведенными в квадрат.
 * @author akochanov
 * @since 21.03.2019
 * @version 1
 */
public class Square {
    /**
     * Метод, заполняющий массив числами, возведенными в квадрат.
     * @param bound - элемент
     * @return - массив
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}