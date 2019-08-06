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
        if (tasks.size() == 0) {
            this.tasks.add(task);
            return;
        }

        for (var i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getPriority() > task.getPriority()) {
                this.tasks.add(i, task);
                return;
            }
        }
        this.tasks.add(task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
