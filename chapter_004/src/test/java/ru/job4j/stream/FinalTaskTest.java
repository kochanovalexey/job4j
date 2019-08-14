package ru.job4j.stream;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 14.08.2019
 */
public class FinalTaskTest {
    @Test
    public void whenArraysNumbersThenSumEvenNumbersSquared() {
        FinalTask finalTask = new FinalTask();
        int[] array = {1, 2, 3, 4, 5, 6};
        int result = finalTask.sumEvenNumbersSquared(array);
        assertThat(result, is(56));
    }
}
