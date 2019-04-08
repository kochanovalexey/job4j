package ru.job4j.tracker;

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

        boolean result = false;
        for (int i = 0; i < items.length; i++) {
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
        for (int i = 0; i < items.length; i++) {
            if (id.equals(items[i].getId())) {
                System.arraycopy(items, i, items, i, 100);
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
        Item[] allItems = new Item[position];
        System.arraycopy(items, 0, allItems, 0, position);
        return allItems;
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
        Item[] foundItems = new Item[index];
        System.arraycopy(tempItems, 0, foundItems, 0, index);
        return foundItems;
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
