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

        List<User> users = List.of(
                firstUser,
                secondUser,
                thirdUser,
                fourthUser,
                fifthUser
        );

        Set<User> expected = new TreeSet();
        expected.addAll(List.of(
                fourthUser,
                fifthUser,
                firstUser,
                secondUser,
                thirdUser
        ));
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

    @Test
    public void whenListUsersSortedByLengthName() {
        SortUser sortUser = new SortUser();

        User firstUser = new User("Andrey", 23);
        User secondUser = new User("Alex", 25);
        User thirdUser = new User("Alexander", 29);
        User fourthUser = new User("Oleg", 22);
        User fifthUser = new User("Serdey", 22);

        List<User> users = Arrays.asList(
                firstUser,
                secondUser,
                thirdUser,
                fourthUser,
                fifthUser
        );

        List<User> result = sortUser.sortNameLength(users);
        List<User> expected = List.of(
                secondUser,
                fourthUser,
                firstUser,
                fifthUser,
                thirdUser
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenListUsersSortedByAllField() {
        SortUser sortUser = new SortUser();

        User firstUser = new User("Serdey", 23);
        User secondUser = new User("Alex", 25);
        User thirdUser = new User("Alexander", 29);
        User fourthUser = new User("Alex", 22);
        User fifthUser = new User("Serdey", 22);

        List<User> users = Arrays.asList(
                firstUser,
                secondUser,
                thirdUser,
                fourthUser,
                fifthUser
        );

        List<User> result = sortUser.sortByAllFields(users);
        List<User> expected = List.of(
                fourthUser,
                secondUser,
                thirdUser,
                fifthUser,
                firstUser
        );
        assertThat(result, is(expected));
    }
}
