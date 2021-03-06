package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Class Класс StartUI
 *
 * @author akochanov
 * @version 1
 * @since 10.04.2019
 */
public class StartUI {

    private boolean working = true;

    int[] range;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Вывод данных
     */
    private final Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions(this);
        range = menu.getAllKey();
        do {
            System.out.println("Меню.");
            menu.show();
            menu.select(input.ask("Введите пункт меню : ", range));
        } while (working);
    }

    public void exit() {
        this.working = false;
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
