package ru.job4j.list;

/**
 * Class Класс Очередь на дву стеках
 *
 * @author akochanov
 * @version 1
 * @since 09.09.2019
 */
public class SimpleQueue<T>{

    /**
     * Первый стек
     */
    private SimpleStack<T> firstStack = new SimpleStack<>();

    /**
     * Второй стек
     */
    private SimpleStack<T> secondStack = new SimpleStack<>();

    /**
     * Push значение
     * @param value - значение
     */
    public void push(T value) {
        this.firstStack.push(value);
    }

    /**
     * Poll значение
     * @return - значение
     */
    public T poll() {
        if (this.secondStack.size() == 0) {
            while (this.firstStack.size() > 0) {
                this.secondStack.push(this.firstStack.poll());
            }
        }
        return this.secondStack.poll();

    }
}
