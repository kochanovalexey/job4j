package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 26.08.2019
 */
public class SimpleArrayTest {

    SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        this.simpleArray = new SimpleArray<>(10);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.add(6);
    }

    @Test
    public void whenTypeIntShouldReturnInt() {
        int result = simpleArray.get(0);
        assertThat(result, is(2));
    }

    @Test
    public void whenSetValueByIndexThanReturnSameValueByIndex() {
        simpleArray.set(1, 7);
        int result = simpleArray.get(1);
        assertThat(result, is(7));
    }

    @Test
    public void whenRemoveValueByIndexThanAllValueAfterIndexShiftLeft() {
        simpleArray.remove(2);
        assertThat(simpleArray.get(2), is(5));
        assertThat(simpleArray.get(3), is(6));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        Iterator<Integer> it = simpleArray.iterator();
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
    }
}