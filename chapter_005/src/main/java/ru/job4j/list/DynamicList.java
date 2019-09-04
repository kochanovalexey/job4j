package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Класс динамический список на основе массива
 *
 * @author akochanov
 * @version 1
 * @since 04.09.2019
 */
public class DynamicList<E> implements Iterable<E> {
    /**
     * Массив объектов
     */
    private Object[] container = new Object[10];
    /**
     * Текущий индекс
     */
    private int index = 0;
    /**
     * Счетчик модифицированности контейнера
     */
    private int modCount = 0;

    /**
     * Добавление элемента
     * @param value - значение
     */
    public void add(E value) {
        if (this.index == this.container.length) {
            this.ensureCapacity();
        }
        this.container[this.index++] = value;
        this.modCount++;
    }

    /**
     * Получение элемента по индексу
     * @param index - индекс
     * @return
     */
    public E get(int index) {
        return (E) this.container[index];
    }

    /**
     * Метод увеличивает емкость массива объектов в два раза
     */
    private void ensureCapacity() {
        this.container = Arrays.copyOf(this.container, (this.index * 3) / 2 + 1);
    }

    @Override
    public Iterator<E> iterator() {
        DynamicList<E> dynamicList = this;
        int index = this.index;
        int expectedModCount = this.modCount;
        return new Iterator<E>() {
            /**
             * Текущий индекс
             */
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                checkModContainer();
                return index > this.currentIndex;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) dynamicList.container[currentIndex++];
            }

            /**
             * Проверка на модифицированность контейнера
             */
            public void checkModContainer() {
                if (dynamicList.modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
