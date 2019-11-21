package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 08.07.2019
 */
public class Calculator {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i != end; i++) {
            list.add(func.apply((double) i));
        }
        return list;
    }
}
