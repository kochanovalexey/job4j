package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 17.09.2019
 */
public class MapTest {
    @Test
    public void map() {
        Map<User, Object> map = new HashMap<>();
        User first = new User("Alex", 23, null);
        User second = new User("Alex", 23, null);
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }
}
