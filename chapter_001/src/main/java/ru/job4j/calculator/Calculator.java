package ru.job4j.calculator;
/**
 * Class Класс калькулятор
 * @author akochanov
 * @since 10.03.2019
 * @version 1
 */
public class Calculator {
    /**
     * Метод выполняющий операцию сложения двух чисел
     * @param first - первое число
     * @param second - второе число
     * @return результат сложения
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Метод выполняющий операцию вычитания одно числа от другого
     * @param first - первое число
     * @param second - второе число
     * @return результат вычитания
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * Метод выполняющий операцию умножения двух чисел
     * @param first - первое число
     * @param second - второе число
     * @return результат умножения
     */
    public double div(double first, double second) {
        return first * second;
    }

    /**
     * Метод выполняющий операцию деления одного числа от другого
     * @param first - первое число
     * @param second - второе число
     * @return результат деления
     */
    public double multiple(double first, double second) {
        return first / second;
    }
}
