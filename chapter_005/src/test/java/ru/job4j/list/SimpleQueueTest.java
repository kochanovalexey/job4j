package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тест SimpleQueue
 *
 * @author akochanov
 * @version 1
 * @since 10.09.2019
 */
public class SimpleQueueTest {

    private SimpleQueue<Integer> simpleQueue;

    @Before
    public void beforeTest() {
        simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
    }

    @Test
    public void whenPollThanReturn1() {
        int result = simpleQueue.poll();
        assertThat(result, is(1));
    }

    @Test
    public void hasPollSequentialInvocation() {
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        simpleQueue.push(4);
        assertThat(simpleQueue.poll(), is(3));
        assertThat(simpleQueue.poll(), is(4));
    }

    @Test
    public void whenPush4ThanPollReturn1() {
        simpleQueue.push(4);
        int result = simpleQueue.poll();
        assertThat(result, is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenPollFourTimesThanNoSuchElementException() {
        simpleQueue.poll();
        simpleQueue.poll();
        simpleQueue.poll();
        simpleQueue.poll();
    }
}