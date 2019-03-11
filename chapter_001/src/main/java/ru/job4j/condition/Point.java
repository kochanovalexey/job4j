package ru.job4j.condition;

/**
 * Class Класс вычисления расстояния методу точками в системе координат
 * @author akochanov
 * @since 11.03.2019
 * @version 1
 */
public class Point {
    /**
     * Метод вычисляющий расстояния методу точками в системе координат
     * @param x1 - координата x первой точки
     * @param y1 - координата y первой точки
     * @param x2 - координата x второй точки
     * @param y2 - координата y второй точки
     * @return Расстояние между точками в системе координат
     */
    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
