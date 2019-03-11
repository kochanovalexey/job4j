package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тест калькулятора
 * @author akochanov
 * @since 10.03.2019
 * @version 1
 */
public class CalculatorTest {
    /**
     * Тест метода add
     */
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Тест метода subtract
     */
    @Test
    public void whenSubtractOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.subtract(3D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Тест метода div
     */
    @Test
    public void whenDivOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.div(2D, 3D);
        double expected = 6D;
        assertThat(result, is(expected));
    }

    /**
     * Тест метода multiple
     */
    @Test
    public void whenMultipleOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.multiple(10D, 2D);
        double expected = 5D;
        assertThat(result, is(expected));
    }
}
