package ru.job4j.generic;

import java.util.Iterator;

/**
 * Class Класс Универсальная обертка над массивом.
 *
 * @author akochanov
 * @version 1
 * @since 26.08.2019
 */
public class SimpleArray<T> implements Iterable<T> {

    /**
     * Массив объектов
     */
    Object[] array;
    /**
     * Индекс
     */
    int index = 0;

    /**
     * Конструктор класса
     * @param size - размер массива
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Добавление значения в массив
     * @param model - значение
     */
    public void add(T model) {
        array[index++] = model;
    }

    /**
     * Изменить элемент по индексу
     * @param index - индекс
     * @param model - значение
     */
    public void set(int index, T model) {
        if (index < this.index) {
            array[index] = model;
        }
    }

    /**
     * Удалить элемент массива по индексу
     * @param index - индекс
     */
    public void remove(int index) {
        System.arraycopy(this.array, index + 1, this.array, index, this.index - index);
    }

    /**
     * Получить значение  по индексу
     * @param index - индекс
     * @return - возращаемое значение
     */
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        Object[] array = this.array;
        int index = this.index;
        return new Iterator<T>() {
            /**
             * Текущий индекс
             */
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return index > this.currentIndex;
            }

            @Override
            public T next() {
                return (T) array[currentIndex++];
            }
        };
    }

}
