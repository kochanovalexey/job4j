package ru.job4j.comparator;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 14.06.2019
 */
public class SortUserTest {
    @Test
    public void whenListOfFiveUserWhenSortedInTreeSet() {
        SortUser sortUser = new SortUser();

        User firstUser = new User("Andrey", 23);
        User secondUser = new User("Alex", 25);
        User thirdUser = new User("Kirill", 29);
        User fourthUser = new User("Oleg", 22);
        User fifthUser = new User("Serdey", 22);

        List<User> users = new ArrayList<>();
        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);
        users.add(fourthUser);
        users.add(fifthUser);

        Set<User> expected = new TreeSet<>();
        expected.add(fourthUser);
        expected.add(fifthUser);
        expected.add(firstUser);
        expected.add(secondUser);
        expected.add(thirdUser);

        Set<User> result = sortUser.sort(users);
        assertThat(result, is(expected));
    }

    @Test
    public void whenEmptyListWhenEmptyTreeSet() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        Set<User> expected = new TreeSet<>();
        Set<User> result = sortUser.sort(users);
        assertThat(result, is(expected));
    }
}
