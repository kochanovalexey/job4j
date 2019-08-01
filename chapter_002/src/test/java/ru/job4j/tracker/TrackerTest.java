package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тестирующий класс Tracker
 *
 * @author akochanov
 * @version 1
 * @since 08.04.2019
 */
public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemTrackerDoNotHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item1 = new Item("test2", "testDescription1", 122L);
        Item item2 = new Item("test1", "testDescription2", 125L);
        tracker.add(item);
        item.setId("1");
        tracker.add(item1);
        item1.setId("2");
        tracker.add(item2);
        item2.setId("3");
        tracker.delete(item2.getId());
        Item result = tracker.findById(item2.getId());
        Item expected = null;
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindByNameItemsFromTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item1 = new Item("test2", "testDescription1", 123L);
        Item item2 = new Item("test1", "testDescription2", 123L);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        List<Item> result = tracker.findByName("test1");
        List<Item> expected = List.of(
                item,
                item2
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindAllItemsFromTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item1 = new Item("test2", "testDescription1", 123L);
        Item item2 = new Item("test1", "testDescription2", 123L);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        List<Item> result = tracker.findAll();
        List<Item> expected = List.of(
                item,
                item1,
                item2
        );
        assertThat(result, is(expected));
    }
}
