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
    private int position = 0;

    public StubInput(String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
}
