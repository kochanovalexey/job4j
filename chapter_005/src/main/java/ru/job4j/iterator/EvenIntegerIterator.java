package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Класс Итератор, возвращающий четные числа последовательности
 *
 * @author akochanov
 * @version 1
 * @since 20.08.2019
 */
public class EvenIntegerIterator implements Iterator {
    /**
     * Входящий массив чисел
     */
    private final int[] numbers;
    /**
     * Индекс
     */
    private int index;

    /**
     * Конструктор класса
     * @param numbers - входящий массив чисел
     */
    public EvenIntegerIterator(final int[] numbers) {
        this.numbers = numbers;
        this.index = 0;
        this.index = returnNextIndex();
    }

    @Override
    public boolean hasNext() {
        return index != -1;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int number = this.numbers[this.index++];
        this.index = returnNextIndex();
        return number;
    }

    /**
     * Возвращает индекс следующего элемента numbers, если не обнаружен, тогда возвращается -1
     * @return - следующий индекс
     */
    private int returnNextIndex() {
        for (int i = this.index; i < this.numbers.length; i++) {
            if (this.numbers[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }
}
