package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 24.07.2019
 */
public class ConverterTest {
    @Test
    public void whenMatrixIntegerConvertToListInteger() {
        Converter converter = new Converter();
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6),
                List.of(7, 8)
        );
        List<Integer> result = converter.convertIntegerMatrixToListInteger(matrix);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(result, is(expect));
    }
}
