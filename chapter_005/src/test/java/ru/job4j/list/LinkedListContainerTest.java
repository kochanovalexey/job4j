package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс, тестирующий LinkedListContainer
 *
 * @author akochanov
 * @version 1
 * @since 05.09.2019
 */
public class LinkedListContainerTest {

    private LinkedListContainer<Integer> list;

    @Before
    public void beforeTest() {
        list = new LinkedListContainer<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenGetTwoThenResultThree() {
        assertThat(list.get(2), is(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenDynamicListChangeThenIteratorReturnConcurrentModificationException() {
        Iterator<Integer> it = list.iterator();
        list.add(7);
        it.hasNext();
    }

    @Test(expected = NullPointerException.class)
    public void whenGetSevenThenNullPointerException() {
        list.get(7);
    }

}