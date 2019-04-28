package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.theInstance;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 17.04.2019
 */
public class StartUITest {

    Tracker tracker = new Tracker();
    Input input;
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String menuText = new StringBuilder()
            .append("Меню.")
            .append(System.lineSeparator())
            .append("0. Добавить новую заявку")
            .append(System.lineSeparator())
            .append("1. Показать все заявки")
            .append(System.lineSeparator())
            .append("2. Редактировать заявку")
            .append(System.lineSeparator())
            .append("3. Удалить заявку")
            .append(System.lineSeparator())
            .append("4. Найти заявку по ID")
            .append(System.lineSeparator())
            .append("5. Найти заявку по имени")
            .append(System.lineSeparator())
            .toString();

    public void createInput(String[] value, int[] keys) {
        input = new StubInput(value, keys);
    }

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        createInput(new String[]{"test name", "desc", "y"}, new int[]{0});   //создаём StubInput с последовательностью действий
        new StartUI(this.input, this.tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(this.tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //Напрямую добавляем заявку
        Item item = this.tracker.add(new Item("test name", "desc", 123L));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        createInput(new String[]{item.getId(), "test replace", "заменили заявку", "y"}, new int[]{2});
        // создаём StartUI и вызываем метод init()
        new StartUI(this.input, this.tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(this.tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasNotContainsItem() {
        Item item = this.tracker.add(new Item("test name", "desc", 123L));
        createInput(new String[]{item.getId(), "y"}, new int[]{3});
        new StartUI(this.input, this.tracker).init();
        Item expected = null;
        assertThat(this.tracker.findById(item.getId()), is(expected));
    }

    @Test
    public void whenShowAllThenPrintAllItems() {
        Item item = this.tracker.add(new Item("test name", "desc", 123L));
        createInput(new String[] {"y"}, new int[]{1});
        new StartUI(this.input, this.tracker).init();

        assertThat(this.out.toString(),
                is(
                        new StringBuilder()
                                .append(menuText)
                                .append("------------ Список всех заявок ------------")
                                .append(System.lineSeparator())
                                .append(String.format("ID: %s", item.getId()))
                                .append(System.lineSeparator())
                                .append(String.format("Name: %s", item.getName()))
                                .append(System.lineSeparator())
                                .append(String.format("Description: %s", item.getDecs()))
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemByNameThenPrintThisItem() {
        Item item = this.tracker.add(new Item("test name", "desc", 123L));
        createInput(new String[] {"test name", "y"}, new int[]{5});
        new StartUI(this.input, this.tracker).init();

        assertThat(this.out.toString(),
                is(
                        new StringBuilder()
                                .append(menuText)
                                .append("------------ Поиск заявок по имени --------------")
                                .append(System.lineSeparator())
                                .append(String.format("ID: %s", item.getId()))
                                .append(System.lineSeparator())
                                .append(String.format("Name: %s", item.getName()))
                                .append(System.lineSeparator())
                                .append(String.format("Description: %s", item.getDecs()))
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}