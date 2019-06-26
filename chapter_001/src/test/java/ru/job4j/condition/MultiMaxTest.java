package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тестирующий класс MultiMax
 * @author akochanov
 * @since 15.03.2019
 * @version 1
 */
public class MultiMaxTest {
    /**
     * Тест метода max, когда первое наибольшее число
     */
    @Test
    public void whenFirstMax() {
        MultiMax multiMax = new MultiMax();
        int max = multiMax.max(3, 2, 1);
        assertThat(max, is(3));
    }

    /**
     * Тест метода max, когда второе наибольшее число
     */
    @Test
    public void whenSecondMax() {
        MultiMax multiMax = new MultiMax();
        int max = multiMax.max(2, 4, 3);
        assertThat(max, is(4));
    }

    /**
     * Тест метода max, когда третье наибольшее число
     */
    @Test
    public void whenThirdMax() {
        MultiMax multiMax = new MultiMax();
        int max = multiMax.max(1, 2, 3);
        assertThat(max, is(3));
    }

    /**
     * Тест метода max, когда все числа равны
     */
    @Test
    public void whenAllMax() {
        MultiMax multiMax = new MultiMax();
        int max = multiMax.max(1, 1, 1);
        assertThat(max, is(1));
    }
}
