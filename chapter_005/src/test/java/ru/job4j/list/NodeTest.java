package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class Класс, тест Node
 *
 * @author akochanov
 * @version 1
 * @since 11.09.2019
 */
public class NodeTest {
    @Test
    public void whenFourNodeHasNextFirstNode() {

        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        boolean result = Node.hasCycle(first);

        assertTrue(result);
    }

    @Test
    public void whenFourNodeHasNextThirdNode() {

        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = third;

        boolean result = Node.hasCycle(first);

        assertTrue(result);
    }

    @Test
    public void whenNodesHasNotCycle() {

        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;

        boolean result = Node.hasCycle(first);

        assertFalse(result);
    }
}