import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GameShould {
    @Test
    public void start_with_all_white_squares() {
        Game game = new Game();

        for (Square square : game.getSquares()) {
            assertTrue(square.isWhite());
        }
    }

    @Test
    public void not_accept_even_square_numbers() {
        Assertions.assertThrows(NotOddSquaresNumber.class, () -> {
            Game game = new Game(2);
        });
    }

    @ParameterizedTest
    @CsvSource({"3", "5", "7"})
    public void accept_odd_square_numbers(int size) {
        Assertions.assertDoesNotThrow(() -> {
            Game game = new Game(size);
        });
    }

    @ParameterizedTest
    @CsvSource({"3", "5", "7"})
    public void build_appropriate_number_of_squares(int size) throws NotOddSquaresNumber {
        Game game = new Game(size);
        assertEquals(size * size, game.getSquares().size());
    }
}