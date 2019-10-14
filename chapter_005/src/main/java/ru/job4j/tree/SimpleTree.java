package ru.job4j.tree;

import java.util.Optional;

public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return - результат
     */
    boolean add(E parent, E child);

    /**
     * Поиск Node по значению
     * @param value - значению
     * @return - Optional
     */
    Optional<Node<E>> findBy(E value);
}
