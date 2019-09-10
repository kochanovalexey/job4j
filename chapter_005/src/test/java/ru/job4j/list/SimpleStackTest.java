package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс, тестирующий Stack
 *
 * @author akochanov
 * @version 1
 * @since 09.09.2019
 */
public class SimpleStackTest {
    private SimpleStack<Integer> simpleStack;

    @Before
    public void beforeTest() {
        simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
    }

    @Test
    public void whenPollThanReturn3() {
        int result = simpleStack.poll();
        assertThat(result, is(3));
    }

    @Test
    public void whenPush4ThanPollReturn4() {
        simpleStack.push(4);
        int result = simpleStack.poll();
        assertThat(result, is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenPollFourTimesThanNoSuchElementException() {
        simpleStack.poll();
        simpleStack.poll();
        simpleStack.poll();
        simpleStack.poll();
    }
}