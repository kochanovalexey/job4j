package ru.job4j;

/**
 * Class Объединяющий два массива в один
 * @author akochanov
 * @since 02.04.2019
 * @version 1
 */
class MergeTwoArray {
    /**
     * Метод, объединяющий два массива в один
     * @param left - первый массив
     * @param right - второй массив
     * @return - объединенный массив
     */
    int[] merge(int[] left, int[] right) {
        int[] mergeArray = new int[left.length + right.length];
        int indexLeft = 0;
        int indexRight = 0;
        for (int i = 0; i < mergeArray.length; i++) {
            if (indexLeft == left.length) {
                mergeArray[i] = right[indexRight++];
                continue;
            } else if (indexRight == right.length) {
                mergeArray[i] = left[indexLeft++];
                continue;
            }
            if (left[indexLeft] > right[indexRight]) {
                mergeArray[i] = right[indexRight++];
            } else {
                mergeArray[i] = left[indexLeft++];
            }
        }
        return mergeArray;
    }
}
