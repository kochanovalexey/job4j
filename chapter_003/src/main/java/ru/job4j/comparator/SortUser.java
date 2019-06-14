package ru.job4j.comparator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class Класс SortUser
 *
 * @author akochanov
 * @version 1
 * @since 14.06.2019
 */
public class SortUser {
    /**
     * Сортировка списка User в TreeSet
     * @param users - список User
     * @return - TreeSet User
     */
    public Set<User> sort (List<User> users) {
        TreeSet<User> treeSet = new TreeSet<>();
        treeSet.addAll(users);
        return treeSet;
    }
}
