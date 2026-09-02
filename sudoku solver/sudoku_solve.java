

public class sudoku_solve {

    static boolean findEmptyCell(char [][] board, int [] emptyCell){
       
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){

                    //store empty cell in rows
                    emptyCell[0] = i;

                    // store empty cell in column
                    emptyCell[1] = j;
                    return true;
                }
            }
            
        }
        return false;
    }

    static boolean isSafeToPlace(char [][] board, char charValue, int rowIndex, int colIndex){
        //rules:

        //horizontally travele karenge
        //jab horizontally chalegne row same rahega
        //col change hote rahega
        for(int col=0; col<9; col++){
            if(board[rowIndex][col] == charValue){
                return false;
            }
        }

        //vertically chek karegne
        //jab vertical travel karenge to col smae rahega
        //row change hote rahega
        for(int row = 0; row<9; row++){
            if(board[row][colIndex] == charValue){
                return false;
            }
        }

        //3X3 ka box dekhenge
        //dimaga lageaga
        int startRow = rowIndex - rowIndex%3;
        int startCol = colIndex - colIndex%3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int actualRow = startRow+i;
                int actualCol = startCol + j;
                if(board[actualRow][actualCol] == charValue){
                    return false;
                }
            }
        }
        return true;

    }

    static  boolean sudokuHelper(char [][] board){

        //base case
        int [] emptyCell = new int [2];

        if(!findEmptyCell(board, emptyCell)){
            return true;
        }

        // if let i found in cell
        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        for(int value = 0; value <9; value++){
            char charValue = (char)(value + '0');

            if(isSafeToPlace(board,charValue, rowIndex, colIndex)){
                //ek case hmm solve karenge baaki recursion sambal lega
                board[rowIndex][colIndex] = charValue;
                //recursiong step
                if(sudokuHelper(board) == true){
                    return true;
                }

                //undo wala step
                board[rowIndex][colIndex] = '.';
            }
        }
        return false;


    }

    public static  void solveSudoku(char [][] board){
        sudokuHelper(board);
    }

    //main method
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        // Solve Sudoku
        solveSudoku(board);

        // Print solved Sudoku
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
