package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Class Класс редактирования заявки.
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class UpdateItem extends BaseAction {

    public UpdateItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("------------ Редактирование заяки ------------");
        String id = input.ask("Введите id заявки для редактирования");
        String name = input.ask("Введите название заявки");
        String desc = input.ask("Введите описание заявки");
        Item item = new Item(name, desc, System.currentTimeMillis());
        boolean result = tracker.replace(id, item);
        if (result) {
            String text = String.format("------------ Заявка с id : %s отредактирована ------------", id);
            output.accept(text);
        } else {
            String text = String.format("------------ Заявка с id: %s не найдена ------------", id);
            output.accept(text);
        }
    }

}
