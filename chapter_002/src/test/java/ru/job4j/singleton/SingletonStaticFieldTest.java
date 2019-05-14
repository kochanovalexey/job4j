package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тестирующий класс SingletonStaticField.
 *
 * @author akochanov
 * @version 1
 * @since 15.05.2019
 */
public class SingletonStaticFieldTest {

    @Test
    public void whenTwoInitializationClassHasOneObject() {
        SingletonStaticField result = SingletonStaticField.getInstance();
        SingletonStaticField expected = SingletonStaticField.getInstance();
        assertThat(result, is(expected));
    }
}
