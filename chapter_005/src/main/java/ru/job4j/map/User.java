package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

}
