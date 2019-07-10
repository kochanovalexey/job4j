package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Class Класс поиска заявки по Id.
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class FindItemById extends BaseAction {

    public  FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("------------ Поиск заявки по id --------------");
        String id = input.ask("Введите id заявки для поиска");
        Item item = tracker.findById(id);
        if (item != null) {
            String nameText = String.format("Name: %s", item.getName());
            String descText = String.format("Description: %s", item.getDecs());
            output.accept(nameText);
            output.accept(descText);
        } else {
            String text = String.format("------------ Заявка с id: %s не найдена ------------", id);
            output.accept(text);
        }
    }

}
