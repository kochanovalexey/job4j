package ru.job4j.tracker;

/**
 * Class Класс поиска заявки по имени.
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class FindItemsByName implements UserAction {
    @Override
    public int key() {
        return 5;
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

    @Override
    public String info() {
        return "5. Найти заявку по имени";
    }
}
