package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Класс Node
 *
 * @author akochanov
 * @version 1
 * @since 14.10.2019
 */
public class Node<E extends Comparable<E>> {

    /**
     * Дочерние Node
     */
    private final List<Node<E>> children = new ArrayList<>();

    /**
     * Значение
     */
    private final E value;

    /**
     * Конструктор
     * @param value - значение root
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Добавление дочернего Node
     * @param child - дочерний Node
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Возвращает дочерние Node
     * @return - дочерние Node
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Сравнивает that с текущим значением
     * @param that - искомое значение
     * @return - результат
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    /**
     * Возвращает значение
     * @return - значние
     */
    public E getValue() {
        return this.value;
    }
}


