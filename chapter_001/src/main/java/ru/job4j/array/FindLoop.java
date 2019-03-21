package ru.job4j.array;

/**
 * Class Класс, находящий индекс элемента, удовлетворяющего условию
 * @author akochanov
 * @since 21.03.2019
 * @version 1
 */
public class FindLoop {
    /**
     * Метод, находящий индекс элемента, удовлетворяющего условию
     * @param data - массив
     * @param el - элемент
     * @return - индекс
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
