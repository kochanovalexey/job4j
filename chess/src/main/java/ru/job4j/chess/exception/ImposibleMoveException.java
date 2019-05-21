package ru.job4j.chess.exception;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 21.05.2019
 */
public class ImposibleMoveException extends RuntimeException {
    public ImposibleMoveException(String message) {
        super(message);
    }
}
