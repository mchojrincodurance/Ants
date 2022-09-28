import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardShould {
    @Test
    public void start_with_all_white_squares() {
        Board board = new Board();

        for (Square square : board.getSquares()) {
            assertTrue(square.isWhite());
        }
    }

    @Test
    public void not_accept_even_square_numbers() {
        Assertions.assertThrows(NotOddSquaresNumber.class, () -> {
            new Board(2);
        });
    }

    @ParameterizedTest
    @CsvSource({"3", "5", "7"})
    public void accept_odd_square_numbers(int size) {
        Assertions.assertDoesNotThrow(() -> {
            new Board(size);
        });
    }

    @ParameterizedTest
    @CsvSource({"3", "5", "7"})
    public void build_appropriate_number_of_squares(int size) throws NotOddSquaresNumber {
        Board board = new Board(size);
        assertEquals(size * size, board.getSquares().size());
    }

    @ParameterizedTest
    @CsvSource({"3,1", "5,2", "7,3"})
    public void calculate_center_position(int size,int posCenter) throws NotOddSquaresNumber {
        Board board = new Board(size);

        Position center = board.getCenter();

        assertEquals(posCenter, center.row());
        assertEquals(posCenter, center.col());
    }

}