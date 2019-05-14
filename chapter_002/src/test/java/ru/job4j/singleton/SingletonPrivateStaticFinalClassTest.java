package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тестирующий класс SingletonPrivateStaticFinalClass.
 *
 * @author akochanov
 * @version 1
 * @since 15.05.2019
 */
public class SingletonPrivateStaticFinalClassTest {

    @Test
    public void whenTwoInitializationClassHasOneObject() {
        SingletonPrivateStaticFinalClass result = SingletonPrivateStaticFinalClass.getInstance();
        SingletonPrivateStaticFinalClass expected = SingletonPrivateStaticFinalClass.getInstance();
        assertThat(result, is(expected));
    }
}