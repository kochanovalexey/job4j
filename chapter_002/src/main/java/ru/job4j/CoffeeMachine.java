package ru.job4j;

import java.util.Arrays;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 28.05.2019
 */
public class CoffeeMachine {
    private final int[] coins = new int[] {1, 2, 5, 10};
    int[] changes(int value, int price) {
        if (value < price) {
            return new int[] {};
        }
        int[] change = new int[5];
        int index = 0;
        int temp = value - price;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (temp >= coins[i]) {
                change[index++] = coins[i];
                temp = temp - coins[i];
                if (change.length == index) {
                    change = Arrays.copyOf(change, change.length * 2);
                }
            }
            if (temp == 0) {
                break;
            }
        }
        return change;
    }
}
