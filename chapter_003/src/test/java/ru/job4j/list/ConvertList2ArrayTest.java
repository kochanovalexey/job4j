package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 03.06.2019
 */
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void when3ElementsThen8() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3),
                2
        );
        int[][] expect = {
                {1, 2},
                {3, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void whenEmptyListThenEmptyArray() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(),
                2
        );
        int[][] expect = {
                {},
                {}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void whenConvertTwoArraysOnListThenOneList() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> arrayList = List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5}
        );
        List<Integer> expected = List.of(
                1,
                2,
                3,
                4,
                5
        );
        List<Integer> result = list.convert(arrayList);
        assertThat(result, is(expected));
    }

    @Test
    public void whenConvertThreeArraysOnListThenOneList() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> arrayList = List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5},
                new int[]{6, 7, 8, 9}
        );
        List<Integer> expected = List.of(
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
        List<Integer> result = list.convert(arrayList);
        assertThat(result, is(expected));
    }

    @Test
    public void whenConvertEmptyArraysOnListThenOneList() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> arrayList = List.of(
                new int[]{}
        );
        List<Integer> expected = Arrays.asList();
        List<Integer> result = list.convert(arrayList);
        assertThat(result, is(expected));
    }
}
