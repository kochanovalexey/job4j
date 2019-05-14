package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class Класс тестирующий ValidateInput
 *
 * @author akochanov
 * @version 1
 * @since 04.05.2019
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Необходимо ввести корректные данные%n")
                )
        );
    }

    @Test
    public void whenOutOfMenu() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"6", "1"})
        );
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Необходимо выбрать значение из диапазона меню и запросить повторно ввод%n")
                )
        );
    }
}
