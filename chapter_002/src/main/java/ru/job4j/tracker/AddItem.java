package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Class Класс создания новой заявки.
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class AddItem extends BaseAction {

    public AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        String text = String.format("------------ Новая заявка с getId : %s -----------", item.getId());
        output.accept(text);
    }

}
