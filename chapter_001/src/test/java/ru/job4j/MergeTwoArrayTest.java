package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MergeTwoArrayTest {

    @Test
    public void whenMergeTwoArray() {
        MergeTwoArray mergeTwoArray = new MergeTwoArray();
        int[] left = {1, 3, 5, 7};
        int[] right = {2, 4, 6};
        int[] result = mergeTwoArray.merge(left, right);
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertThat(result, is(expected));
    }

}
