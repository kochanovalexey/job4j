package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Class Класс Итератор двумерного массива
 *
 * @author akochanov
 * @version 1
 * @since 19.08.2019
 */
public class MatrixIterator implements Iterator {
    /**
     * Массив
     */
    private final int[][] array;

    /**
     * Внешний индекс
     */
    private int outerIndex = 0;

    /**
     * Внутренний индекс
     */
    private int innerIndex = 0;

    /**
     * Конструктор класса
     * @param array - входящий массив
     */
    public MatrixIterator(final int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return this.array[this.outerIndex].length > this.innerIndex
                || this.array.length > this.outerIndex + 1;
    }

    @Override
    public Object next() {
        if (this.array[this.outerIndex].length > this.innerIndex) {
            return this.array[this.outerIndex][this.innerIndex++];
        } else {
            this.innerIndex = 0;
            return this.array[++this.outerIndex][this.innerIndex++];
        }
    }
}
