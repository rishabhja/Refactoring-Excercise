import com.sun.tools.javac.util.Pair;

public class ChessBoard {

    private final Piece[][] board = new Piece[9][9];

    public ChessBoard() {
        resetBoard();
    }

    private void resetBoard() {
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 8; j++)
                board[i][j] = new Piece(Piece.Color.WHITE);
        }
        for (int i = 3; i <= 6; i++) {
            for (int j = 1; j <= 8; j++) {
                board[i][j] = new Piece(Piece.Color.NONE);
            }
        }
        for (int i = 7; i <= 8; i++) {
            for (int j = 1; j <= 8; j++)
                board[i][j] = new Piece(Piece.Color.BLACK);
        }
    }

    public void printBoard() {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public boolean isEmpty(Pair<Integer, Integer> position) {
        return board[position.fst][position.snd].getColor() == Piece.Color.NONE;
    }

    public GameEngine.Player getPlayer(Pair<Integer, Integer> position) {
        Piece.Color color = board[position.fst][position.snd].getColor();
        if (color == Piece.Color.WHITE)
            return GameEngine.Player.FIRST;
        if (color == Piece.Color.BLACK)
            return GameEngine.Player.SECOND;
        throw new RuntimeException("No piece present on the position");
    }

    public boolean movePiece(Pair<Integer, Integer> source, Pair<Integer, Integer> destination) {
        Piece startPiece = board[source.fst][source.snd];
        if (!startPiece.validateMove(source, destination)) {
            System.out.println("Invalid Move!!");
            return false;
        }
        board[destination.fst][destination.snd] = board[source.fst][source.snd];
        board[source.fst][source.snd] = new Piece(Piece.Color.NONE);
        return true;
    }
}
