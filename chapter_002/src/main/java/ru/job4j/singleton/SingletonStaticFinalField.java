package ru.job4j.singleton;

/**
 * Class Класс, реализующий паттерн Singleton
 * Объявляя и инициализуруя статическое final поле класса
 *
 * @author akochanov
 * @version 1
 * @since 15.05.2019
 */
public class SingletonStaticFinalField {

    private static final SingletonStaticFinalField INSTANCE = new SingletonStaticFinalField();

    private SingletonStaticFinalField() {

    }

    public static SingletonStaticFinalField getInstance() {
        return INSTANCE;
    }
}
