package ru.job4j.tracker;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 07.05.2019
 */
public abstract class BaseAction implements UserAction {

    private final int key;
    private final String name;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }


    @Override
    public int key() {
        return key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
