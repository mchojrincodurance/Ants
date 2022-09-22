import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Square> squares = null;

    public Board() {
        initDefaultSquares();
    }

    private void initDefaultSquares() {
        initSquares(3);
    }

    public Board(int square_number) throws NotOddSquaresNumber {
        isEven(square_number);

        initSquares(square_number);
    }

    private void initSquares(int square_number) {
        squares = new ArrayList<>();
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

    public Position getCenter() {
        int size = getSize();
        return new Position(size/2,size/2);
    }

    public int getSize() {
        Double size = Math.sqrt(squares.size());
        return  size.intValue();
    }
}
