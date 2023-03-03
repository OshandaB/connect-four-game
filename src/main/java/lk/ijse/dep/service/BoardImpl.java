package lk.ijse.dep.service;

public class BoardImpl  implements Board  {




    private  Piece[][] pieces ;
    private final BoardUI boardUI ;




    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public BoardImpl(BoardUI boardUI) {
     pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
     this.boardUI = boardUI;
        for (int i = 0; i <NUM_OF_COLS ; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                pieces[i][j] = Piece.EMPTY;

            }

        }


        //updateMove(3,Piece.BLUE);

    }




    @Override
    public BoardUI getBoardUI() {
        System.out.println(pieces[0][0]);
        System.out.println(pieces[1][0]);

   return  boardUI;

    }

    @Override
    public int findNextAvaliableSpot(int col) {
  int count = 0;


           for (int i =0; i<5; i++) {
               if (pieces[col][i].equals(Piece.EMPTY) ) {
                   count = i;
                   break;

               }else{
                   count = -1;

               }
           }

           return count;



        // If no empty cells were found in the column, return -1

    }        /*if(col<0 || col>pieces[0].length){
            return -1;
        }else{
            return col;

        }*/


        /*if (count >=5) {
            return -1;
        }else  {
            return col;
        }*/



    @Override
    public boolean isLegalMove(int col) {
        int count = findNextAvaliableSpot(col);
        if(count == -1){
            return false;
        }else {

    }
   return true;

    }
    @Override
    public boolean exitLegalMoves() {
      for(int i =0; i<NUM_OF_COLS; i++){
          for (int j = 0; j<NUM_OF_ROWS; j++){
              if(pieces[i][j]==Piece.EMPTY){
                  return true;
              }
          }
      }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        int count = findNextAvaliableSpot(col);
        //boardUI.update(col,true);

       // boardUI.update(col,false);
        pieces[col][count] = move;






    }


    @Override
    public void updateMove(int col, int row, Piece move) {
        pieces[col][row] = move;
    }

    @Override
    public Winner findWinner() {
        int col1 = -1;
        int col2 = -1;
        int row1 = -1;
        int row2 = -1;
        Winner winner = null ;
        int bCount = 0;
        int gCount = 0;
        for (int i=0; i<6; i++){
            bCount =0;
            gCount =0;
            for (int j=0; j<5; j++){
                if(pieces[i][j].equals(Piece.BLUE)){
                    bCount++;
                    if(bCount==1){
                        col1= i;
                        row1=j;
                    }if(bCount ==4){
                        col2 =i;
                        row2 = j;
                        winner = new Winner(Piece.BLUE,col1,row1,col2,row2);
                    }
                }else{
                    bCount =0;
                }
                if(pieces[i][j].equals(Piece.GREEN)){
                    gCount++;
                    if(gCount==1){
                        col1= i;
                        row1=j;
                    }if(gCount ==4){
                        col2 =i;
                        row2 = j;
                        winner = new Winner(Piece.GREEN,col1,row1,col2,row2);
                    }
            }else{
                    gCount =0;
                }
        }



    }
        for (int i=0; i<5; i++){
            bCount =0;
            gCount =0;
            for (int j=0; j<6; j++){
                if(pieces[j][i].equals(Piece.BLUE)){
                    bCount++;
                    if(bCount==1){
                        col1= j;
                        row1=i;
                    }if(bCount ==4){
                        col2 =j;
                        row2 = i;
                        winner = new Winner(Piece.BLUE,col1,row1,col2,row2);
                    }
                }else{
                    bCount =0;
                }
                if(pieces[j][i].equals(Piece.GREEN)){
                    gCount++;
                    if(gCount==1){
                        col1= j;
                        row1=i;
                    }if(gCount ==4){
                        col2 =j;
                        row2 = i;
                        winner = new Winner(Piece.GREEN,col1,row1,col2,row2);
                    }
                }else{
                    gCount =0;
                }
            }



        }
        if(winner==null){
            winner = new Winner(Piece.EMPTY);
        }
        return winner;
    }

}
