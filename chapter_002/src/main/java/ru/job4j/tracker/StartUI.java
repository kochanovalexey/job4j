package ru.job4j.tracker;

/**
 * Class Класс StartUI
 *
 * @author akochanov
 * @version 1
 * @since 10.04.2019
 */
public class StartUI {

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
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        range = menu.getAllKey();
        do {
            System.out.println("Меню.");
            menu.show();
            menu.select(input.ask("Введите пункт меню : ", range));
        } while (!"y".equals(this.input.ask("Выйти?")));
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
