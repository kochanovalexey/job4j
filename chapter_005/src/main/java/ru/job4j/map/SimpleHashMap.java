package ru.job4j.map;

import java.util.*;

/**
 * Class Класс SimpleHashMap
 *
 * @author akochanov
 * @version 1
 * @since 21.09.2019
 */
public class SimpleHashMap<K,V> implements Iterable<V> {

    /**
     * Контейнер
     */
    private Entry<K,V>[] container;

    /**
     * Индекс
     */
    private int occupancy = 0;

    /**
     * Конструктор без параметров
     */
    public SimpleHashMap() {
        this.container = new Entry[16];
    }

    /**
     * Конструктор с размером емкости
     * @param capacity - емкость
     */
    public SimpleHashMap(int capacity) {
        this.container = new Entry[capacity];
    }

    /**
     * Вставить пару ключ-значение
     * @param key - ключ
     * @param value - значение
     * @return - результат вставки
     */
    boolean insert(K key, V value) {
        boolean result = true;
        int hashcode = hash(key);
        int index = indexFor(hashcode, this.container.length);
        if (this.container[index] != null) {
            result = key.equals(this.container[index].key);
        }
        if (result) {
            this.container[index] = new Entry<>(key, value, hashcode);
            this.occupancy++;
        }
        if (this.occupancy == container.length) {
            ensureCapacity();
        }
        return result;
    }

    /**
     *
     * @param h
     * @param length
     * @return
     */
    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    /**
     * Получить значение по ключу
     * @param key - ключ
     * @return - значение
     */
    V get(K key) {
        V result = null;
        int hashcode = hash(key);
        int index = indexFor(hashcode, this.container.length);
        if (this.container[index] != null) {
            result = this.container[index].value;
        }
        return result;
    };

    /**
     * Удалить пару ключ-значение по ключу
     * @param key - ключ
     * @return - результат удаления
     */
    boolean delete(K key) {
        boolean result = false;
        int hashcode = hash(key);
        int index = indexFor(hashcode, this.container.length);
        if (this.container[index] != null) {
            this.container[index] = null;
            this.occupancy++;
            result = true;
        }
        return result;
    };

    /**
     * Получение hashcode ключа
     * @param key - ключ
     * @return - hashcode
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * Увеличить емкость контейнера
     */
    private void ensureCapacity() {
        this.container = Arrays.copyOf(this.container, (this.container.length * 3) / 2 + 1);
    }

    @Override
    public Iterator<V> iterator() {
        Entry<K,V>[] container = this.container;
        int occupancy = this.occupancy;
        return new Iterator<V>() {

            int quantity = 0;
            int index = 0;

            @Override
            public boolean hasNext() {
                return occupancy != quantity;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                V value = null;
                while (value == null) {
                    if (container[index] != null) {
                        value = container[index].value;
                        quantity++;
                    }
                    index++;
                }
                return value;
            }
        };
    }

    /**
     * Класс записи
     * @param <K> - ключ
     * @param <V> - значение
     */
    private static class Entry<K,V> {

        /**
         * Hashcode ключа
         */
        int hashcode;

        /**
         * Ключ
         */
        private K key;

        /**
         * Значение
         */
        private V value;

        /**
         * Коснтруктор
         * @param key - ключ
         * @param value - значение
         * @param hashcode - hashcode
         */
        public Entry(K key, V value, int hashcode) {
            this.key = key;
            this.value = value;
            this.hashcode = hashcode;
        }
    }
}
