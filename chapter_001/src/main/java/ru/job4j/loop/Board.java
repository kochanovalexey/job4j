package ru.job4j.loop;

/**
 * Class Класс, рисующий шахматную доску
 * @author akochanov
 * @since 19.03.2019
 * @version 1
 */
public class Board {
    /**
     * Метод, рисующий шахматную доску
     * @param width - ширина
     * @param height - высота
     * @return - шахматная доска
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
