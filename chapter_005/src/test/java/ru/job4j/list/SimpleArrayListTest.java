package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс, тестирующий SimpleArrayList
 *
 * @author akochanov
 * @version 1
 * @since 03.09.2019
 */
public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteElementThenUseGetZeroResultTwo() {
        list.delete();
        assertThat(list.get(0), is(2));
    }

    @Test
    public void whenDeleteElementThenUseGetSizeResultTwo() {
        list.delete();
        assertThat(list.getSize(), is(2));
    }
}