package ru.job4j.tree;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class Класс тестирующий Tree
 *
 * @author akochanov
 * @version 1
 * @since 14.10.2019
 */
public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(1, 5);
        tree.add(2, 6);
        tree.add(2, 7);
        tree.add(3, 8);
        tree.add(8, 9);

        Iterator<Integer> it = tree.iterator();
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(2));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(3));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(4));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(5));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(6));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(7));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(8));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(9));
        assertThat(it.hasNext(), Is.is(false));
    }
}
