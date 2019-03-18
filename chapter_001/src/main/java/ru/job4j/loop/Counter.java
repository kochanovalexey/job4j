package ru.job4j.loop;

/**
 * Class Класс вычесления суммы четных чисел в заданном диапазоне
 * @author akochanov
 * @since 19.03.2019
 * @version 1
 */
public class Counter {
    /**
     * Метод вычесляющий суммы четных чисел в заданном диапазоне
     * @param start - начало диапазона
     * @param finish - конец диапазона
     * @return - сумма четных чисел
     */
    public int add(int start, int finish) {

        int sum = 0;

        for(int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
