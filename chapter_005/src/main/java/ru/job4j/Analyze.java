package ru.job4j;

import java.util.*;

/**
 * Class Класс Analyze
 *
 * @author akochanov
 * @version 1
 * @since 15.10.2019
 */
public class Analyze {
    /**
     * Класс Info
     * @param previous - предыдущий List
     * @param current - текущий List
     * @return - Info
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();

        Map<Integer, String> previousMap = new HashMap<>();
        for (User user : previous) {
            previousMap.put(user.id, user.name);
        }
        Map<Integer, String> currentMap = new HashMap<>();
        for (User user : current) {
            currentMap.put(user.id, user.name);
        }
        Set<Integer> previousId = previousMap.keySet();
        Set<Integer> currentId = currentMap.keySet();

        Set<Integer> newId = new HashSet<>(currentId);
        newId.removeAll(previousId);
        info.added = newId.size();

        Set<Integer> deletedId = new HashSet<>(previousId);
        Set<Integer> temp = new HashSet<>(currentId);
        temp.removeAll(newId);
        deletedId.removeAll(temp);
        info.deleted = deletedId.size();

        Set<Integer> sharedId = new HashSet<>(currentId);
        sharedId.removeAll(newId);

        Map<String, Integer> map = new HashMap<>();
        for (Integer id : sharedId) {
            map.put(previousMap.get(id), id);
        }
        int mapSize = map.size();
        for (Integer id : sharedId) {
            map.put(currentMap.get(id), id);
        }
        info.changed = map.size() - mapSize;

        return info;
    }

    /**
     * Класс User
     */
    public static class User {
        /**
         * ID
         */
        private int id;
        /**
         * Имя
         */
        private String name;

        /**
         * Конструктор
         * @param id - ID
         * @param name - имя
         */
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        /**
         * Добавлено пользователей
         */
        int added;
        /**
         * Изменено пользователей
         */
        int changed;
        /**
         * Удалено пользователей
         */
        int deleted;
    }
}
