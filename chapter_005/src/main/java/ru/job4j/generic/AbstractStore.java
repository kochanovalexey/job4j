package ru.job4j.generic;

import java.util.Iterator;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 27.08.2019
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * SimpleArray
     */
    public SimpleArray<T> simpleArray;

    /**
     * Конструктор
     * @param simpleArray - SimpleArray
     */
    public AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndex(id);
        if (index == -1) {
            return false;
        }
        this.simpleArray.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndex(id);
        if (index == -1) {
            return false;
        }
        this.simpleArray.remove(index);
        return true;
    }

    @Override
    public T findById(String id) {
        int index = findIndex(id);
        if (index == -1) {
            return null;
        }
        return this.simpleArray.get(index);
    }

    /**
     * Найти индекс по id
     * @param id - id
     * @return - индекс
     */
    private int findIndex(String id) {
        Iterator<T> it = this.simpleArray.iterator();
        int index = 0;
        while (it.hasNext()) {
            Base temp = it.next();
            if (temp == null) {
                return -1;
            }
            if (id.equals(temp.getId())) {
                return index;
            }
        }
        return -1;
    }
}
