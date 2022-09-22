public class Game {
    private final Board board;
    private final Position antPosition;

    public Game(Board board) {
        this.board = board;
        antPosition = this.board.getCenter();
    }

    public String showBoard() {
        String result = "";
        Position currentPosition = new Position(0, 0);
        int size = board.getSize();
        for (Square square : board.getSquares()) {
            if (currentPosition.equals(antPosition)) {
                result += "x";
            } else {
                result += ".";
            }
            if(currentPosition.getCol() == size-1) {
                result += "\n";
                currentPosition = new Position(currentPosition.getRow() +1 , 0);
            }
            else {
                currentPosition = new Position(currentPosition.getRow()  , currentPosition.getCol() +1);
            }
        }
        return result;
    }
}
