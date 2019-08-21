package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Класс convert(Iterator<Iterator>)
 *
 * @author akochanov
 * @version 1
 * @since 21.08.2019
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            /**
             * Входящий Iterator<Iterator<Integer>>
             */
            Iterator<Iterator<Integer>> iters = it;
            /**
             * Текущий Iterator<Integer>
             */
            Iterator<Integer> currentIt = nextIterator();
            @Override
            public boolean hasNext() {
                return currentIt != null;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int number = this.currentIt.next();
                if (!this.currentIt.hasNext()) {
                    this.currentIt = nextIterator();
                }
                return number;
            }

            /**
             * Следующий Iterator<Integer>
             * @return - Iterator<Integer>
             */
            private Iterator<Integer> nextIterator() {
                Iterator<Integer> temp = this.iters.hasNext() ? this.iters.next() : null;
                if (temp == null) {
                    return temp;
                }
                while (temp != null && !temp.hasNext()) {
                    temp = this.iters.hasNext() ? this.iters.next() : null;
                }
                return temp;
            }
        };
    }
}
