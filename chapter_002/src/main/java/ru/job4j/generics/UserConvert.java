package ru.job4j.generics;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/**
 * Class Класс, ковертирующий list в HashMap
 *
 * @author akochanov
 * @version 1
 * @since 11.06.2019
 */
public class UserConvert {
    /**
     * Метод преобразует List с пользователями
     * в HashMap с id Integer и соответствующим User
     * @param list - входящий List с пользователями
     * @return - HashMap
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        ListIterator<User> listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            User user = listIterator.next();
            hashMap.put(user.getId(), user);
        }
        return hashMap;
    }
}
