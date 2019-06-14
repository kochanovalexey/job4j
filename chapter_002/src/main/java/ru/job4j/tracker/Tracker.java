package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
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
        for (int i = 0; i < this.items.size(); i++) {
            if (id.equals(this.items.get(i).getId())) {
                this.items.set(i, item);
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
        for (int i = 0; i < this.items.size(); i++) {
            if (id.equals(items.get(i).getId())) {
                this.items.remove(i);
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
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод реализующий получение заявок по наименованию
     * @param key - искомое наименование
     * @return - массив найденных заявок
     */
    public List<Item> findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (Item item : this.items) {
            if (key.equals(item.getName())) {
                temp.add(item);
            }
        }
        return temp;
    }

    /**
     * Метод реализующий получение заявки по id
     * @param id - искомое id заявки
     * @return - найденная заяка
     */
    public Item findById(String id) {
        Item foundItem = null;
        for (Item item : this.items) {
            if (id.equals(item.getId())) {
                foundItem = item;
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
