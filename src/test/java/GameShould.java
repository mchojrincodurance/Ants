import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould
{
    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    public void put_the_ant_in_the_middle_of_the_board(int size, String expectedBoardStatus) throws NotOddSquaresNumber {
        Board board = new Board(size);
        Game game = new Game(board);

        String boardStatus = game.showBoard();

        assertEquals(expectedBoardStatus, boardStatus);
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(3,
                        "...\n" +
                        ".x.\n" +
                        "...\n"),
                Arguments.of(5,
                        ".....\n" +
                        ".....\n" +
                        "..x..\n" +
                        ".....\n" +
                        ".....\n")
        );
    }
}