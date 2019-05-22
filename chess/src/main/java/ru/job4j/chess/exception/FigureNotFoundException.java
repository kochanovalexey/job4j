package ru.job4j.chess.exception;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 22.05.2019
 */
public class FigureNotFoundException extends  RuntimeException {
    public FigureNotFoundException(String message) {
        super(message);
    }
}
