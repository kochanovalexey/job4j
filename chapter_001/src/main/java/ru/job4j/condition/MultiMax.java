package ru.job4j.condition;

/**
 * Class Класс вычисления максимального числа
 * @author akochanov
 * @since 15.03.2019
 * @version 1
 */
public class MultiMax {
    /**
     * Мтеод вычисляющий максимально число из трех чисел
     * @param first - первое число
     * @param second - второе число
     * @param third - третье число
     * @return - максимальное число
     */
    public int max(int first, int second, int third) {
        int max = first >= second ? first : second;
        max = max >= third ? max : third;
        return max;
    }
}
