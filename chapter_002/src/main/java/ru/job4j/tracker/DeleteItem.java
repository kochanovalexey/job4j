package ru.job4j.tracker;

/**
 * Class Класс удаления заявки.
 *
 * @author akochanov
 * @version 1
 * @since 22.04.2019
 */
public class DeleteItem implements UserAction {
    @Override
    public int key() {
        return 3;
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

    @Override
    public String info() {
        return "3. Удалить заявку";
    }
}
