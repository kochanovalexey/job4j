package ru.job4j.tracker;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class ExitProgram extends BaseAction {

    StartUI ui;

    public ExitProgram(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        this.ui.exit();
    }

}
