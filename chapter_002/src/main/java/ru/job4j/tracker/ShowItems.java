package ru.job4j.tracker;

import java.util.List;

/**
 * Class Класс, который показывает все заявки.
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        System.out.println("------------ Список всех заявок ------------");
        for (Item item : items) {
            String idText = String.format("ID: %s", item.getId());
            String nameText = String.format("Name: %s", item.getName());
            String descText = String.format("Description: %s", item.getDecs());
            System.out.println(idText);
            System.out.println(nameText);
            System.out.println(descText);
            System.out.println();
        }
    }

}
