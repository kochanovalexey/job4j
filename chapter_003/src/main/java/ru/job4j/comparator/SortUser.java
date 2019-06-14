package ru.job4j.comparator;

import java.util.*;

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

    /**
     * Сортировка списка User по длине имени
     * @param users - входящий список User
     * @return - отсортированный список User
     */
    public List<User> sortNameLength (List<User> users) {
        class LengthComparator implements Comparator {
            @Override
            public int compare(Object o1, Object o2) {
                User u1 = (User) o1;
                User u2 = (User) o2;
                return u1.getName().length() - u2.getName().length();
            }
        }
        LengthComparator lengthComparator = new LengthComparator();
        Collections.sort(users, lengthComparator);
        return users;
    }

    /**
     * Сортировка списка User по полям name и age
     * @return - отсортированный список User
     */
    public List<User> sortByAllFields (List<User> users) {
        class AllFieldComparator implements Comparator {
            @Override
            public int compare(Object o1, Object o2) {
                User u1 = (User) o1;
                User u2 = (User) o2;
                int result = u1.getName().compareTo(u2.getName());
                return result != 0 ? result : u1.compareTo(u2);
            }
        }
        AllFieldComparator allFieldComparator = new AllFieldComparator();
        Collections.sort(users, allFieldComparator);
        return users;
    }
}
