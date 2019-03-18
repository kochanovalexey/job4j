package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тестирующий класс Counter
 * @author akochanov
 * @since 19.03.2019
 * @version 1
 */
public class CounterTest {
    /**
     * Тест метода add, когда сумма четных чисел из диапазона от 1 до 10 равна 30
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }
}
