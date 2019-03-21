package ru.job4j.array;

/**
 * Class Класс, переворачивающий массив.
 * @author akochanov
 * @since 21.03.2019
 * @version 1
 */
public class Turn {
    /**
     * Метод, переворачивающий массив.
     * @param array - массив
     * @return - перевернутый массив
     */
    public int[] back(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
