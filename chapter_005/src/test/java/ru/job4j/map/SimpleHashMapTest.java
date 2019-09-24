package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тестирующий SimpleHashMap
 *
 * @author akochanov
 * @version 1
 * @since 24.09.2019
 */
public class SimpleHashMapTest {

    private SimpleHashMap<User, String> simpleHashMap;

    @Before
    public void beforeTest() {
        simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(new User("Alex", 2, null), "first");
        simpleHashMap.insert(new User("Irina", 0, null), "second");
        simpleHashMap.insert(new User("Fedor", 1, null), "third");
    }

    @Test
    public void whenInsertNewKeyWithValueFourThenGetKeyValues() {
        User user = new User("Dmitrii", 2, null);
        simpleHashMap.insert(user, "four");
        String result = simpleHashMap.get(user);
        assertThat(result, is("four"));
    }

    @Test
    public void whenDeleteKeyTwoThenGetKeyNull() {
        User user = new User("Irina", 0, null);
        simpleHashMap.delete(user);
        String result = simpleHashMap.get(user);
        assertNull(result);
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        Iterator<String> it = simpleHashMap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("third"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("first"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("second"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
