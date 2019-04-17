package ru.job4j.pseudo;

/**
 * Class Класс, рисующий квадрат
 *
 * @author akochanov
 * @version 1
 * @since 17.04.2019
 */
public class Square implements Shape {
    /**
     * Метод, рисующий квадрат.
     * @return - квадрат.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append(System.lineSeparator());
        pic.append("+  +");
        pic.append(System.lineSeparator());
        pic.append("+  +");
        pic.append(System.lineSeparator());
        pic.append("++++");
        return pic.toString();
    }
}
