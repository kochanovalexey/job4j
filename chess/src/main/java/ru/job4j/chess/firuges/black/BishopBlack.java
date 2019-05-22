package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.exception.*;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImposibleMoveException("Слон может двигаться только по диагонали");
        }

        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int deltaX = source.x > dest.x ? -1 : 1;
        int deltaY = source.y > dest.y ? -1 : 1;
        int positionX = source.x;
        int positionY = source.y;

        for (int i = 0; i < size; i++) {
            positionX = positionX + deltaX;
            positionY = positionY + deltaY;
            for (Cell cell : Cell.values()) {
                if (cell.x == positionX && cell.y == positionY) {
                    steps[i] = cell;
                    break;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y);
    }
}
