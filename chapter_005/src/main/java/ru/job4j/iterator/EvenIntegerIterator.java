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
    private int index = 0;

    /**
     * Конструктор класса
     * @param numbers - входящий массив чисел
     */
    public EvenIntegerIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        return returnNextIndex() != -1;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.index = returnNextIndex();
        return this.numbers[this.index++];
    }

    /**
     * Возвращает индекс следующего элемента numbers, если не обнаружен, тогда возвращается -1
     * @return - следующий индекс
     */
    private int returnNextIndex() {
        for(int i = this.index; i < this.numbers.length; i++) {
            if (this.numbers[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }
}
