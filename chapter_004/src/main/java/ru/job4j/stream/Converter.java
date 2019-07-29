package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 24.07.2019
 */
public class Converter {
    public List<Integer> convertIntegerMatrixToListInteger(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
