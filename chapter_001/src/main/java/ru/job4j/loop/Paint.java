package ru.job4j.loop;

/**
 * Class Класс, рисующий пирамиду
 * @author akochanov
 * @since 19.03.2019
 * @version 1
 */
public class Paint {
    /**
     * Метод, рисующий пирамиду
     * @param height - высота
     * @return - пирамида
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int width= 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
