package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тестирующий класс SingletonStaticFinalField.
 *
 * @author akochanov
 * @version 1
 * @since 15.05.2019
 */
public class SingletonStaticFinalFieldTest {

    @Test
    public void whenTwoInitializationClassHasOneObject() {
        SingletonStaticFinalField result = SingletonStaticFinalField.getInstance();
        SingletonStaticFinalField expected = SingletonStaticFinalField.getInstance();
        assertThat(result, is(expected));
    }
}
