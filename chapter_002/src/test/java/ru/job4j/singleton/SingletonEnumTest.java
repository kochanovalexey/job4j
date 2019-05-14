package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тестирующий класс SingletonEnum.
 *
 * @author akochanov
 * @version 1
 * @since 15.05.2019
 */
public class SingletonEnumTest {

    @Test
    public void whenTwoInitializationClassHasOneObject() {
        SingletonEnum result = SingletonEnum.INSTANCE;
        SingletonEnum expected = SingletonEnum.INSTANCE;
        assertThat(result, is(expected));
    }
}
