package ru.job4j.tracker;

/**
 * Class Класс, который показывает все заявки.
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class ShowItems implements UserAction {
    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
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

    @Override
    public String info() {
        return "1. Показать все заявки";
    }
}
