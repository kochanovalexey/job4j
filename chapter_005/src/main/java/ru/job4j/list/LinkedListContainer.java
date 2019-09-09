package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Класс контейнер на базе связанного списка
 *
 * @author akochanov
 * @version 1
 * @since 05.09.2019
 */
public class LinkedListContainer<E> implements Iterable<E> {
    /**
     * Первый элемент
     */
    private Node<E> first;

    /**
     * Счетчик модифицированности
     */
    int modCount = 0;

    /**
     * Добавление элемента
     * @param value - значение
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.modCount++;
    }

    /**
     * Получение элемента по индексу
     * @param index - индекс
     * @return - возращаемый элемент
     */
    public E get(int index) {
        Node<E> result = this.first;
        for(int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод удаляет последнийэлемент списка
     * @return - удаляемый элемент
     */
    public E removeLast() {
        if (this.first == null) {
            throw new NoSuchElementException();
        }
        E data = this.first.data;
        this.first = this.first.next;
        return data;
    }

    @Override
    public Iterator<E> iterator() {
        LinkedListContainer<E> list = this;
        return new Iterator<E>() {
            /**
             * Текущий узел
             */
            Node<E> currentLink = list.first;

            /**
             * Ожидаемый счетчик модифицированности
             */
            int expectedModCount = list.modCount;
            @Override
            public boolean hasNext() {
                checkModContainer();
                return this.currentLink != null;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> result = this.currentLink;
                this.currentLink = this.currentLink.next;
                return result.data;
            }

            /**
             * Проверка на модифицированность контейнера
             */
            public void checkModContainer() {
                if (expectedModCount != list.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private static class Node<E> {
        /**
         *
         */
        E data;

        /**
         *
         */
        Node<E> next;

        /**
         *
         * @param data
         */
        Node(E data) {
            this.data = data;
        }
    }
}
