package ru.job4j.map;

import java.util.Calendar;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 16.09.2019
 */
public class User {
    /**
     * Имя
     */
    String name;
    /**
     * Количество детей
     */
    int children;
    /**
     * День рождения
     */
    Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
