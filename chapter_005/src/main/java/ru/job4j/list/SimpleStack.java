package ru.job4j.list;

/**
 * Class Класс Stack
 *
 * @author akochanov
 * @version 1
 * @since 09.09.2019
 */
public class SimpleStack<T> {

    /**
     * Контейнер
     */
    LinkedListContainer<T> list = new LinkedListContainer<>();
    /**
     * Текущий индекс
     */
    private int index = 0;

    /**
     * Poll значение из коллекции
     * @return - последний элемент коллекции
     */
    public T poll() {
        T data = list.removeLast();
        this.index--;
        return data;
    }

    /**
     * Push значение в коллекцию
     * @param value - значение
     */
    public void push(T value) {
        list.add(value);
        this.index++;
    }

    public int size() {
        return this.index;
    }
}
