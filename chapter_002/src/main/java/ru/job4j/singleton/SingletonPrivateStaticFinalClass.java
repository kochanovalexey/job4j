package ru.job4j.singleton;

/**
 * Class Класс, реализующий паттерн Singleton
 * Создается вложенный статический final класс,
 * который инициализирует внешний класс
 *
 * @author akochanov
 * @version 1
 * @since 15.05.2019
 */
public class SingletonPrivateStaticFinalClass {

    private SingletonPrivateStaticFinalClass() {

    }

    public static SingletonPrivateStaticFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final SingletonPrivateStaticFinalClass INSTANCE = new SingletonPrivateStaticFinalClass();
    }

}
