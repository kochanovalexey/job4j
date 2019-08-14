package ru.job4j.stream;

import java.util.Arrays;

/**
 * Class Класс, выводящий сумму всех четных чисел в квадрате
 *
 * @author akochanov
 * @version 1
 * @since 14.08.2019
 */
public class FinalTask {
    /**
     * Метод, возвращающий сумму всех четных чисел в квадрате
     * @param array - массив чисел
     * @return - результат
     */
    public int sumEvenNumbersSquared(int[] array) {
        return Arrays.stream(array)
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .sum();
    }
}
