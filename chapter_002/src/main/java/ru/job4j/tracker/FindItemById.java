package ru.job4j.tracker;

/**
 * Class Класс поиска заявки по Id.
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class FindItemById implements UserAction {
    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = input.ask("Введите id заявки для поиска");
        Item item = tracker.findById(id);
        if (item != null) {
            String nameText = String.format("Name: %s", item.getName());
            String descText = String.format("Description: %s", item.getDecs());
            System.out.println(nameText);
            System.out.println(descText);
        } else {
            String text = String.format("------------ Заявка с id: %s не найдена ------------", id);
            System.out.println(text);
        }
    }

    @Override
    public String info() {
        return "4. Найти заявку по ID";
    }
}
