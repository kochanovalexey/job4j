package ru.job4j.list;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс, тестирующий DynamicList
 *
 * @author akochanov
 * @version 1
 * @since 04.09.2019
 */
public class DynamicListTest {

    private DynamicList<Integer> dynamicList;

    @Before
    public void beforeTest() {
        dynamicList = new DynamicList<>();
        dynamicList.add(1);
        dynamicList.add(2);
        dynamicList.add(3);
        dynamicList.add(4);
        dynamicList.add(5);
        dynamicList.add(6);
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        Iterator<Integer> it = dynamicList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenGetTwoThenResultThree() {
        assertThat(dynamicList.get(2), is(3));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenDynamicListChangeThenIteratorReturnConcurrentModificationException() {
        Iterator<Integer> it = dynamicList.iterator();
        dynamicList.add(7);
        it.hasNext();
    }

}
