package ru.job4j.stream;

/**
 * Class Класс, описывающий Студентов
 *
 * @author akochanov
 * @version 1
 * @since 18.07.2019
 */
public class Student {
    /**
     * Общий балл
     */
    int score;

    /**
     * Фамилия
     */
    String surname;

    /**
     * Имя
     */
    String name;
    /**
     * Конструктор класса
     * @param score - общий балл
     */
    public Student(int score) {
        this.score = score;
    }


    public Student(int score, String surname, String name) {
        this.score = score;
        this.surname = surname;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
}
