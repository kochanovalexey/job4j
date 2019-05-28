package ru.job4j;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 28.05.2019
 */
public class CoffeeMachineTest {
    @Test
    public void whenChange15ToCoins() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] result = coffeeMachine.changes(50, 35);
        assertThat(result, is(
                new int[] {10, 5, 0, 0, 0}
        ));
    }
}
