package lk.ijse.dep.service;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AiPlayer extends Player {

    public AiPlayer(Board board) {
        super(board);


    }

    @Override
    public void movePiece(int col) {

        //int bestScore = (int) Double.NEGATIVE_INFINITY;;


        /*do {
            int min = 0;
            int max = 5;

            col = (int) (Math.random() * (max - min + 1) + min);
        }while (board.isLegalMove(col)==false);*/



            int bestScore = (int) Double.NEGATIVE_INFINITY;
            ;
            System.out.println(bestScore + " old");
            int i;
            for (i = 0; i < 6; i++) {

                if (board.isLegalMove(i)) {

                    int row = board.findNextAvaliableSpot(i);
                    board.updateMove(i, Piece.GREEN);
                    int heuristicVal = minimax(0, false);
                    System.out.println("col " + i +" "+ heuristicVal);


                    board.updateMove(i, row, Piece.EMPTY);
                    System.out.println(heuristicVal+"  heasristic new");
                    System.out.println(bestScore+"  best new");

                    if (heuristicVal > bestScore) {
                        bestScore = heuristicVal;

                        System.out.println(bestScore);
                        col = i;


                        System.out.println(col+" col name");

                    }

                    //System.out.println(bestScore+" new");
                }

            }
        System.out.println();

        // col=minimax(0,false);
       // System.out.println(col+ " col num");
        if(board.isLegalMove(col)) {
            board.updateMove(col, Piece.GREEN);
            board.getBoardUI().update(col, false);
            Winner winner = board.findWinner();
            if (winner.getWinningPiece().equals(Piece.GREEN)) {
                board.getBoardUI().notifyWinner(winner);
            } else {
                if (board.exitLegalMoves() == false) {
                    board.getBoardUI().notifyWinner(winner);
                }
            }
        }

    }
    private int minimax(int depth, boolean maximisingPlayer) {
        Winner winner = board.findWinner();
        if(depth == 4 ){

            /*if(winner.getWinningPiece().equals(Piece.EMPTY)){
                return 0;
            }*/
            //
            if(winner.getWinningPiece().equals(Piece.GREEN)){
                return 1;
            }
            // return 1;
            if(winner.getWinningPiece().equals(Piece.BLUE)){
                return -1;
            }
            return 0;
            //return -1;
        }
        int row;


        if(maximisingPlayer ){

            int maxEval=(int) Double.NEGATIVE_INFINITY;

            for (int i = 0; i < 6; i++) {


                if(board.isLegalMove(i)){
                    //System.out.println("oshanda");
                    row = board.findNextAvaliableSpot(i);
                    board.updateMove(i, Piece.GREEN);
                    int heuristicVal = minimax(depth + 1, false);
                    //System.out.println(heuristicVal+" sampath");
                    board.updateMove(i, row, Piece.EMPTY);
                    maxEval = Math.max(maxEval,heuristicVal);
                   // System.out.println(maxEval+" max");
                      if(heuristicVal==1){
                          return heuristicVal;
                      }


                }

            }
            //System.out.println(maxEval+" max");
            return maxEval;
        } else {
            int minEval=(int) Double.POSITIVE_INFINITY;
            for (int i = 0; i < 6; i++) {

                if(board.isLegalMove(i)){
                    row = board.findNextAvaliableSpot(i);
                    board.updateMove(i, Piece.BLUE);
                    int heuristicVal = minimax(depth + 1, true);
                    board.updateMove(i, row, Piece.EMPTY);

                    minEval = Math.min(minEval,heuristicVal);
                   // System.out.println(minEval);



                }

            }
            return minEval;
        }


    }



}