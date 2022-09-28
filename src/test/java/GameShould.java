import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould
{
    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    public void put_the_ant_in_the_middle_of_the_board(int size, String expectedBoardStatus) throws NotOddSquaresNumber, TooShortSequence, InvalidCharacter {
        Board board = new Board(size);
        Game game = new Game(board, new Sequence("RR"));

        String boardStatus = game.showBoard();

        assertEquals(expectedBoardStatus, boardStatus);
    }
    @ParameterizedTest
    @MethodSource("provideStringsForExecute")
    public void execute_a_sequence(Board board, Sequence sequence, String expectedBoardStatus) {
        Game game = new Game(board, sequence);

        game.execute();

        String boardStatus = game.showBoard();
        assertEquals(expectedBoardStatus, boardStatus);
    }

    private static Stream<Arguments> provideStringsForExecute() throws NotOddSquaresNumber, TooShortSequence, InvalidCharacter {
        return Stream.of(
                Arguments.of(new Board(3),
                        new Sequence("RL"),
                                ".>.\n" +
                                ".*.\n" +
                                "...\n"),
                Arguments.of(new Board(3),
                        new Sequence("LR"),
                                ".<.\n" +
                                ".*.\n" +
                                "...\n")
        );
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(3,
                        "...\n" +
                        ".^.\n" +
                        "...\n"),
                Arguments.of(5,
                        ".....\n" +
                        ".....\n" +
                        "..^..\n" +
                        ".....\n" +
                        ".....\n")
        );
    }
}