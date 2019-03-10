package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtractOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.subtract(3D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.div(2D, 3D);
        double expected = 6D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultipleOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.multiple(10D, 2D);
        double expected = 5D;
        assertThat(result, is(expected));
    }
}
