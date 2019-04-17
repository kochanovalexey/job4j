package ru.job4j.pseudo;

/**
 * Class Класс, рисующий фигуру
 *
 * @author akochanov
 * @version 1
 * @since 17.04.2019
 */
public class Paint {
    /**
     * Метод, реализующий вывод фигуры в консоль.
     * @param shape - фигура.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
