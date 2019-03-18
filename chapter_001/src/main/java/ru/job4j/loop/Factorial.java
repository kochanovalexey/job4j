package ru.job4j.loop;

/**
 * Class Класс вычесления факториала числа
 * @author akochanov
 * @since 19.03.2019
 * @version 1
 */
public class Factorial {
    /**
     * Метод вычесляющий факториала числа
     * @param n - число
     * @return - факториал числа
     */
    public int calc(int n) {
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
