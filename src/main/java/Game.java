import java.util.Arrays;
import java.util.List;

public class Game {

    private List<Square> squares = null;

    public Game() {
        initDefaultSquares();
    }

    private void initDefaultSquares() {
        squares = Arrays.asList(
                new Square(), new Square(), new Square(),
                new Square(), new Square(), new Square(),
                new Square(), new Square(), new Square()
        );
    }

    public Game(int square_number) throws NotOddSquaresNumber {
        isEven(square_number);

        initSquares(square_number);
    }

    private void initSquares(int square_number) {
        for (int i = 0; i < square_number * square_number; i++) {
            squares.add(new Square());
        }
    }

    private static void isEven(int square_number) throws NotOddSquaresNumber {
        if (square_number % 2 == 0) {
            throw new NotOddSquaresNumber();
        }
    }

    public List<Square> getSquares() {
        return squares;
    }
}
