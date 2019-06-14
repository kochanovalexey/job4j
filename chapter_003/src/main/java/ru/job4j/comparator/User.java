package ru.job4j.comparator;

/**
 * Class Класс User
 *
 * @author akochanov
 * @version 1
 * @since 14.06.2019
 */
public class User implements Comparable {
    /**
     * Имя
     */
    private String name;
    /**
     * Возраст
     */
    private int age;

    /**
     * Конструктор
     * @param name - имя
     * @param age - возраст
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Метод compareTo()
     * @param o - входящий Object
     * @return - результат сравнения
     */
    @Override
    public int compareTo(Object o) {
        User entry = (User) o;
        int result = age - entry.age;
        return result !=0 ? result / Math.abs(result) : result;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
