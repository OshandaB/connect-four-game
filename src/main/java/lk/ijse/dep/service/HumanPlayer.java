package lk.ijse.dep.service;

public class HumanPlayer extends Player  {
    public HumanPlayer(Board board) {
        super(board);


    }

    @Override
    public void movePiece(int col) {
try {

    board.updateMove(col, Piece.BLUE);
    board.getBoardUI().update(col, true);
    Winner winner = board.findWinner();
    //board.findNextAvaliableSpot(col);
    if (winner.getWinningPiece() == Piece.BLUE || winner.getWinningPiece() == Piece.GREEN) {
        board.getBoardUI().notifyWinner(winner);
    } else if (board.exitLegalMoves() == false) {
        board.getBoardUI().notifyWinner(winner);
    }
}catch (Exception e){}


    }
}
