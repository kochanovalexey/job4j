package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 29.05.2019
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();

        for(Person person : persons) {
            if (key.contains(person.getSurname()) || key.contains(person.getName()) || key.contains(person.getAddress()) || key.contains(person.getPhone())) {
                result.add(person);
            }
        }
        return result;
    }
}
