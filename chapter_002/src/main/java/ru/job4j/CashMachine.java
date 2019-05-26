package ru.job4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CashMachine {

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note, int maxCoin) {
        List<List<Integer>> result = new ArrayList<>();
        if (note == 0) {
            result.add(new ArrayList<>());
        } else {
            for (int i = this.values.length - 1; i >= 0; i--) {
                int coin = values[i];
                if (coin > note || coin > maxCoin) {
                    continue;
                }
                for (List<Integer> remain : exchange(note - coin, coin)) {
                    List<Integer> set = new ArrayList<>();
                    set.add(coin);
                    set.addAll(remain);
                    Collections.sort(set);
                    result.add(set);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> exchange(int note) {
        int maxCoin = -1;

        for (int i = 0; i < this.values.length; i++) {
            if (maxCoin < this.values[i]) {
                maxCoin = this.values[i];
            }
        }
        List<List<Integer>> result = exchange(note, maxCoin);
        Collections.reverse(result);
        return result;
    }
}