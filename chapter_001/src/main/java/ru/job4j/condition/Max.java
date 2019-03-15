package ru.job4j.condition;

/**
 * Class Класс вычисления максимального числа
 * @author akochanov
 * @since 15.03.2019
 * @version 1
 */
public class Max {
    /**
     * Метод возвращающий макимальное число
     * @param first - первое число
     * @param second - второе число
     * @return - наибольшее число
     */
    public int max(int first, int second) {
        return first >= second ? first : second;
    }
}
