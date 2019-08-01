package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс, тестирующий класс ConvertMatrix2List
 *
 * @author akochanov
 * @version 1
 * @since 04.06.2019
 */
public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = List.of(
                1,
                2,
                3,
                4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
    @Test
    public void when3on3ArrayThenList6() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> expect = List.of(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
    @Test
    public void whenEmptyArrayThenEmptyList() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {};
        List<Integer> expect = new ArrayList<>();
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}
