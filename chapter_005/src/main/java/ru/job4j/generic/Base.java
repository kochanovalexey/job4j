package ru.job4j.generic;

/**
 * Class Абстрактный класс Base
 *
 * @author akochanov
 * @version 1
 * @since 27.08.2019
 */
public abstract class Base {
    /**
     * ID
     */
    private final String id;

    /**
     * Конструктор
     * @param id - id
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Получить id
     * @return
     */
    public String getId() {
        return this.id;
    }
}
