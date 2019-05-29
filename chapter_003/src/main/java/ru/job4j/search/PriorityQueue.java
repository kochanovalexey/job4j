package ru.job4j.search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 29.05.2019
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int count = this.tasks.size();
        for (int i = 0; i < count; i++) {
            if (this.tasks.get(i).getPriority() >= task.getPriority()) {
                count = i;
                break;
            }
        }
        this.tasks.add(count, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
