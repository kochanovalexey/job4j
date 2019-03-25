package ru.job4j.array;

/**
 * Class Алгоритм пузырьковой сортировки.
 * @author akochanov
 * @since 25.03.2019
 * @version 1
 */
public class BubbleSort {
    /**
     * Метод пузырьковой сортировки массива
     * @param array - исходный массив
     * @return - отсортированный массив
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
