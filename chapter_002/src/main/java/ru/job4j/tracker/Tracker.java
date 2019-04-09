package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Class Класс Трекера
 *
 * @author akochanov
 * @version 1
 * @since 08.04.2019
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод реализующий редактирование заявки в хранилище
     * @param id - id искомой заявки
     * @param item - заявка на замену
     * @return - результат выполнения метода
     */
    boolean replace(String id, Item item) {
        item.setId(id);
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (id.equals(items[i].getId())) {
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Методо реализующий удаление заявки из хранилища по id
     * @param id - id искомой заявки
     * @return - результат выполнения метода
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (id.equals(items[i].getId())) {
                System.arraycopy(items, i + 1, items, i, position - i - 1);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возращающий все заявки из хранилища
     * @return - массив заявок
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Метод реализующий получение заявок по наименованию
     * @param key - искомое наименование
     * @return - массив найденных заявок
     */
    public Item[] findByName(String key) {
        Item[] tempItems = new Item[100];
        int index = 0;
        for(int i = 0; i < position; i++) {
            if (key.equals(items[i].getName())) {
                tempItems[index++] = items[i];
            }
        }
        return Arrays.copyOf(tempItems, index);
    }

    /**
     * Метод реализующий получение заявки по id
     * @param id - искомое id заявки
     * @return - найденная заяка
     */
    public Item findById(String id) {
        Item foundItem = null;
        for(int i = 0; i < position; i++) {
            if (id.equals(items[i].getId())) {
                foundItem = items[i];
                break;
            }
        }
        return foundItem;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return Double.toString(System.currentTimeMillis() * 45.98);
    }
}
