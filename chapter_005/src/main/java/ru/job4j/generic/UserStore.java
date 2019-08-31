package ru.job4j.generic;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 27.08.2019
 */
public class UserStore extends AbstractStore<User> {

    /**
     * Конструктор
     */
    public UserStore() {
        super(new SimpleArray<User>(10));
    }
}
