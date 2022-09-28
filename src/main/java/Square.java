public class Square {
    boolean isWhite = true;

    public boolean isWhite() {
        return isWhite;
    }

    public void flip() {
        isWhite = !isWhite;
    }
}
