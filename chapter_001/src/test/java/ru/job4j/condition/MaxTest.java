package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class Класс тестирующий класс Max
 * @author akochanov
 * @since 15.03.2019
 * @version 1
 */
public class MaxTest {
    /**
     * Тест метода max, когда второе число больше первого
     */
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Тест метода max, когда первое число больше второго
     */
    @Test
    public void whenMax2To1Then2() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }

    /**
     * Тест метода max, когда оба числа равны
     */
    @Test
    public void whenMax2To2Then2() {
        Max max = new Max();
        int result = max.max(2, 2);
        assertThat(result, is(2));
    }

}
