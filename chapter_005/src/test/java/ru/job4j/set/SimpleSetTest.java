package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.SimpleStack;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тестирующий SimpleSet
 *
 * @author akochanov
 * @version 1
 * @since 13.09.2019
 */
public class SimpleSetTest {

    SimpleSet<Integer> simpleSet;

    @Before
    public void setUp() {
        simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(4);
        simpleSet.add(5);
    }
    @Test
    public void whenAdd3ThanSetHasOne3() {
        simpleSet.add(3);
        Iterator<Integer> it = simpleSet.iterator();
        int numberOfTriples = 0;
        while (it.hasNext()) {
            if (it.next() == 3) {
                numberOfTriples++;
            }
        }
        assertThat(numberOfTriples, is(1));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        Iterator<Integer> it = simpleSet.iterator();
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
        assertThat(it.hasNext(), is(false));
    }
    @Test
    public void test() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(null);
        set.add(2);
        set.add(1);
        Iterator<Integer> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertNull(it.next());
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }
}