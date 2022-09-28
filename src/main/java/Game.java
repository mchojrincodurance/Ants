public class Game {
    private final Board board;
    private Position antPosition;
    private final Sequence sequence;
    private Orientation antOrientation = Orientation.NORTH;

    public Game(Board board, Sequence sequence) {
        this.board = board;
        this.sequence = sequence;
        antPosition = this.board.getCenter();
    }

    public String showBoard() {
        String result = "";
        Position currentPosition = new Position(0, 0);
        int size = board.getSize();
        for (Square square : board.getSquares()) {
            result += square2string(currentPosition, square);

            if (isRowEnd(currentPosition, size)) {
                result += "\n";
            }

            currentPosition = getNextPosition(currentPosition, size);
        }

        return result;
    }

    private static Position getNextPosition(Position currentPosition, int size) {
        if (isRowEnd(currentPosition, size)) {
            currentPosition = new Position(currentPosition.row() + 1, 0);
        } else {
            currentPosition = new Position(currentPosition.row(), currentPosition.col() + 1);
        }
        return currentPosition;
    }

    private static boolean isRowEnd(Position currentPosition, int size) {
        return currentPosition.col() == size - 1;
    }

    private String square2string(Position currentPosition, Square square) {
        if (currentPosition.equals(antPosition)) {

            return renderAnt();
        }

        return square.isWhite() ? "." : "*";
    }

    private String renderAnt() {
        return switch (antOrientation) {
            case NORTH -> "^";
            case SOUTH -> "_";
            case EAST -> ">";
            case WEST -> "<";
        };
    }

    public void execute() {
        board.flip(antPosition);
        antPosition = new Position(0,1);
        char command = getNextCommand();

        if (command == 'R') {
            antOrientation = switch (antOrientation) {
                case NORTH -> Orientation.EAST;
                case SOUTH -> Orientation.WEST;
                case EAST -> Orientation.SOUTH;
                case WEST -> Orientation.NORTH;
            };
        } else {
            antOrientation = switch (antOrientation) {
                case NORTH -> Orientation.WEST;
                case SOUTH -> Orientation.EAST;
                case EAST -> Orientation.NORTH;
                case WEST -> Orientation.SOUTH;
            };
        }
    }

    private char getNextCommand() {
        return sequence.getCommand(0);
    }
}
