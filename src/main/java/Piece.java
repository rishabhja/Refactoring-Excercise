import com.sun.tools.javac.util.Pair;

public class Piece {
    private Color _color;

    public Piece(Color color) {
        this._color = color;
    }

    public Color getColor() {
        return _color;
    }

    public boolean validateMove(Pair<Integer, Integer> start, Pair<Integer, Integer> destination) {
        return true;
    }

    public enum Color {
        NONE, WHITE, BLACK
    }

    @Override
    public String toString() {
        switch (_color) {
            case BLACK:
                return "B";
            case WHITE:
                return "W";
            default:
                return ".";
        }
    }
}
