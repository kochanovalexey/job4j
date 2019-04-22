package ru.job4j.tracker;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class ExitProgram implements UserAction {
    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return "6. Выйти из программы";
    }
}
