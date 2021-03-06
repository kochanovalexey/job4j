package ru.job4j.array;

/**
 * Class Квадратный массив заполнен true или false по диагоналям.
 * @author akochanov
 * @since 25.03.2019
 * @version 1
 */
public class MatrixCheck {
    /**
     * Метод проверяющий,что все элементы по диагоналям равны true или false.
     * @param data - массив
     * @return - результат проверки
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1] || data[i][data.length - i - 1] != data[i + 1][data.length - i - 2]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
