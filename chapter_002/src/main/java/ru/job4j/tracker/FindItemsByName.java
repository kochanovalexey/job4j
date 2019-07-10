package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

/**
 * Class Класс поиска заявки по имени.
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("------------ Поиск заявок по имени --------------");
        String name = input.ask("Введите имя заявок для поиска");
        List<Item> items = tracker.findByName(name);
        if (items.size() != 0) {
            for (Item item : items) {
                String idText = String.format("ID: %s", item.getId());
                String nameText = String.format("Name: %s", item.getName());
                String descText = String.format("Description: %s", item.getDecs());
                output.accept(idText);
                output.accept(nameText);
                output.accept(descText);
            }
        } else {
            String text = String.format("------------ Заявки с именем %s не найдены ------------", name);
            output.accept(text);
        }
    }

}
