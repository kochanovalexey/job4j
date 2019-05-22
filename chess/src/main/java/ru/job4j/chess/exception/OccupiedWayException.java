package ru.job4j.chess.exception;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 22.05.2019
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String message) {
        super(message);
    }
}
