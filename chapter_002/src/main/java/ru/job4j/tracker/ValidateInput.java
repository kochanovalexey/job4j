package ru.job4j.tracker;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 25.04.2019
 */
public class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Необходимо выбрать значение из диапазона меню и запросить повторно ввод");
            } catch (NumberFormatException nfe) {
                System.out.println("Необходимо ввести корректные данные");
            }
        } while (invalid);
        return value;
    }
}
