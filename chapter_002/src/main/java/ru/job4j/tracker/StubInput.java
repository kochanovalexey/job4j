package ru.job4j.tracker;

/**
 * Class Класс StubInput
 *
 * @author akochanov
 * @version 1
 * @since 17.04.2019
 */
public class StubInput implements Input {

    private final String[] value;
    private final int[] keys;
    private int positionString = 0;
    private int positionKeys = 0;

    public StubInput(String[] value, int[] keys) {
        this.value = value;
        this.keys = keys;
    }

    @Override
    public String ask(String question) {
        return this.value[this.positionString++];
    }

    @Override
    public int ask(String question, int[] range) {
        return this.keys[this.positionKeys++];
    }
}
