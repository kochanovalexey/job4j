package ru.job4j.set;

import com.sun.source.tree.IfTree;
import ru.job4j.list.DynamicList;

import java.util.Iterator;

/**
 * Class Класс коллекция set
 *
 * @author akochanov
 * @version 1
 * @since 12.09.2019
 */
public class SimpleSet<E> implements Iterable<E> {
    /**
     * Контейнер
     */
    private DynamicList<E> list = new DynamicList<>();

    /**
     * Добавление значения
     * @param value - значение
     */
    public void add(E value) {
        if (!this.hasValue(value)) {
            list.add(value);
        }
    }

    /**
     * Метод проверяющий наличие значение в коллекции
     * @param value - значение
     * @return - результат
     */
    public boolean hasValue(E value) {
        boolean result = false;
        Iterator<E> it = list.iterator();
        while (it.hasNext()) {
            if (value == null ? value == it.next() : value.equals(it.next())) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
