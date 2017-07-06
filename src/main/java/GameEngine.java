import com.sun.tools.javac.util.Pair;

public class GameEngine {
    private final ChessBoard chessBoard;
    private Player currentPlayer;

    public GameEngine() {
        chessBoard = new ChessBoard();
        currentPlayer = Player.FIRST;
    }

    public void makeMove(Pair<Integer, Integer> start, Pair<Integer, Integer> destination) {
        if (!isValidMove(start, destination)) {
            System.out.println("Invalid Move");
            return;
        }
        chessBoard.printBoard();
        System.out.println("Doing move for Player : " + currentPlayer);

        if (chessBoard.movePiece(start, destination)) {
            currentPlayer = getNextPlayer();
            System.out.println("Move successful!!");
            chessBoard.printBoard();
        } else {
            System.out.println("Move failed!! Retry");
        }
    }

    private Player getNextPlayer() {
        return currentPlayer == Player.FIRST ? Player.SECOND : Player.FIRST;
    }

    private boolean isValidMove(Pair<Integer, Integer> start, Pair<Integer, Integer> destination) {
        if(chessBoard.isEmpty(start))
            return false;
        if(!chessBoard.isEmpty(destination)&&chessBoard.getPlayer(destination)==currentPlayer)
            return false;
        if(chessBoard.getPlayer(start)!=currentPlayer)
            return false;
        return true;
    }

    public enum Player {
        FIRST, SECOND
    }

}
