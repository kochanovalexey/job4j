package ru.job4j.singleton;

/**
 * Class Класс, реализующий паттерн Singleton
 * Объявляя статическое поле класса,
 * которое инициализируется в статическом методе
 *
 * @author akochanov
 * @version 1
 * @since 15.05.2019
 */
public class SingletonStaticField {

    private static SingletonStaticField instance;

    private SingletonStaticField() {

    }

    public static SingletonStaticField getInstance() {
        if (instance == null) {
            instance = new SingletonStaticField();
        }
        return instance;
    }
}
