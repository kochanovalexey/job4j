package ru.job4j.generic;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 27.08.2019
 */
public class RoleStore extends AbstractStore<Role> {
    /**
     * Конструктор
     */
    public RoleStore() {
        super(new SimpleArray<Role>(10));
    }
}
