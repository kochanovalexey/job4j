package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 04.07.2019
 */
public class SortDepartmentTest {
    @Test
    public void whenArrayDepartmentSort() {
        SortDepartment sortDepartment = new SortDepartment();
        String[] array = {
                "K1\\\\SK1",
                "K1\\\\SK2",
                "K1\\\\SK1\\\\SSK1",
                "K1\\\\SK1\\\\SSK2",
                "K2",
                "K2\\\\SK1\\\\SSK1",
                "K2\\\\SK1\\\\SSK2"
        };
        String[] result = sortDepartment.sort(array);
        String[] excepted = {
                "K1",
                "K1\\\\SK1",
                "K1\\\\SK1\\\\SSK1",
                "K1\\\\SK1\\\\SSK2",
                "K1\\\\SK2",
                "K2",
                "K2\\\\SK1",
                "K2\\\\SK1\\\\SSK1",
                "K2\\\\SK1\\\\SSK2"
        };
        assertThat(result, is(excepted));
    }
    @Test
    public void whenArrayDepartmentSortDescending() {
        SortDepartment sortDepartment = new SortDepartment();
        String[] array = {
                "K1\\\\SK1",
                "K1\\\\SK2",
                "K1\\\\SK1\\\\SSK1",
                "K1\\\\SK1\\\\SSK2",
                "K2",
                "K2\\\\SK1\\\\SSK1",
                "K2\\\\SK1\\\\SSK2"
        };
        String[] result = sortDepartment.sortDescending(array);
        String[] excepted = {
                "K2",
                "K2\\\\SK1",
                "K2\\\\SK1\\\\SSK1",
                "K2\\\\SK1\\\\SSK2",
                "K1",
                "K1\\\\SK1",
                "K1\\\\SK1\\\\SSK1",
                "K1\\\\SK1\\\\SSK2",
                "K1\\\\SK2"
        };
        assertThat(result, is(excepted));
    }
}
