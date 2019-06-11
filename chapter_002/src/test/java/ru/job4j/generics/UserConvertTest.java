package ru.job4j.generics;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 11.06.2019
 */
public class UserConvertTest {
    @Test
    public void whenListWithThreeUsersConvertToHashMap() {
        UserConvert userConvert = new UserConvert();
        User firstUser = new User(12, "Lora", "Saint Petersburg");
        User secondUser = new User(3, "Kirill", "Helsinki");
        User thirdUser = new User(5, "Kate", "Moscow");

        List<User> list = Arrays.asList(
                firstUser, secondUser, thirdUser
        );
        HashMap<Integer, User> result = userConvert.process(list);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(firstUser.getId(),firstUser);
        expect.put(secondUser.getId(),secondUser);
        expect.put(thirdUser.getId(),thirdUser);
        assertThat(result, is(expect));
    }

    @Test
    public void whenListWithTwoUsersConvertToHashMap() {
        UserConvert userConvert = new UserConvert();
        User firstUser = new User(12, "Lora", "Saint Petersburg");
        User secondUser = new User(3, "Kirill", "Helsinki");

        List<User> list = Arrays.asList(
                firstUser, secondUser
        );
        HashMap<Integer, User> result = userConvert.process(list);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(firstUser.getId(),firstUser);
        expect.put(secondUser.getId(),secondUser);
        assertThat(result, is(expect));
    }

    @Test
    public void whenEmptyListConvertToHashMap() {
        UserConvert userConvert = new UserConvert();
        List<User> list = Arrays.asList();
        HashMap<Integer, User> result = userConvert.process(list);
        HashMap<Integer, User> expect = new HashMap<>();
        assertThat(result, is(expect));
    }
}
