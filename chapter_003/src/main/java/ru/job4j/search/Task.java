package ru.job4j.search;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 29.05.2019
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
