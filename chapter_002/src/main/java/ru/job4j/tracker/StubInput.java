package ru.job4j.tracker;

/**
 * Class Класс StubInput
 *
 * @author akochanov
 * @version 1
 * @since 17.04.2019
 */
public class StubInput implements Input  {

    private final String[] values;
    private int position = 0;

    public StubInput(String[] value) {
        this.values = value;
    }

    @Override
    public String ask(String question) {
        return this.values[this.position++];
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.parseInt(this.values[this.position++]);
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Значение не содержится в меню");
        }
    }
}
