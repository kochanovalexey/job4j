package ru.job4j.tracker;

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
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявок по имени --------------");
        String name = input.ask("Введите имя заявок для поиска");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item item : items) {
                String idText = String.format("ID: %s", item.getId());
                String nameText = String.format("Name: %s", item.getName());
                String descText = String.format("Description: %s", item.getDecs());
                System.out.println(idText);
                System.out.println(nameText);
                System.out.println(descText);
                System.out.println();
            }
        } else {
            String text = String.format("------------ Заявки с именем %s не найдены ------------", name);
            System.out.println(text);
        }
    }

}
