package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[] {
                "Привет", "Мир", "Привет", "Супер", "Мир", "Супер"
        });
        assertThat(result, is(new String[]{"Привет", "Мир", "Супер"}));
    }
}
