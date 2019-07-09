package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 08.07.2019
 */
public class CalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calculator calculator = new Calculator();
        List<Double> result = calculator.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        Calculator calculator = new Calculator();
        List<Double> result = calculator.diapason(4, 7, x -> 2 * Math.pow(x, 2) + 3 * x + 1);
        List<Double> expected = Arrays.asList(45D, 66D, 91D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenLogarithmicFunctionThenLinearResults() {
        Calculator calculator = new Calculator();
        List<Double> result = calculator.diapason(1, 4, x -> Math.log(x));
        List<Double> expected = Arrays.asList(0D, 0.6931471805599453D, 1.0986122886681098D);
        assertThat(result, is(expected));
    }
}
