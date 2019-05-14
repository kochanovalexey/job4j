package ru.job4j.tracker;

/**
 * Class Класс удаления заявки.
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки --------------");
        String id = input.ask("Введите id заявки для удаления");
        boolean result = tracker.delete(id);
        if (result) {
            String text = String.format("------------ Заявка с id: %s удалена ------------", id);
            System.out.println(text);
        } else {
            String text = String.format("------------ Заявка с id: %s не найдена ------------", id);
            System.out.println(text);
        }
    }

}
