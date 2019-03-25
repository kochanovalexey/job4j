package ru.job4j.array;

/**
 * Class Класс, проверяющий, что все элементы в массиве являются true или false
 * @author akochanov
 * @since 21.03.2019
 * @version 1
 */
public class Check {

    /**
     * Метод, проверяющий, что все элементы в массиве являются true или false
     * @param data - массив
     * @return - результат
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] =! data[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
