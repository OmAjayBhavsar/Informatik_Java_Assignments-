public class Sudoku {
    public static boolean helper(char[][] board, int row, int col) {
        if(row == board.length){
            return true;
        }

        int newRow = 0;
        int newCol = 0;
        if (col != board.length - 1) {
            newRow = row;
            newCol = col + 1;
        } else {
            newRow = row + 1;
            newCol = 0;
        }
        if (board[row][col] != '.') {
            if (helper(board, newRow, newCol)) {
                return true;
            } else {
                for (int i = 1; i <= 9; i++) {
                    if (isSafe(board, row, col, i)) {
                        board[row][col] = (char) (i + '0');
                        if (helper(board, newRow, newCol)) {
                            return true;
                        } else {
                            board[row][col] = '.';
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col, int number){
        // row and column
        for (int i = 0; i<board.length; i++){
            if(board[i][col] == (char)(number + '0')){
                return false;
            }
            if (board[row][i] == (char)(number + '0')){
                return false;
            }
        }

        // grid
        int startingRow = (row/3) * 3;
        int startingCol = (col/3) * 3;
        for (int i = startingRow; i<startingRow+3; i++){
            for (int j = startingCol; i<startingCol+3; j++){
                if(board[i][j] == (char)(number + '0')){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sudoku sudokuSolver = new Sudoku();

        // Example Sudoku board
        char[][] sudokuBoard = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Original Sudoku:");
        printSudoku(sudokuBoard);

//        if{isSafe(sudokuBoard,9,9)}

        System.out.println("\nSolved Sudoku:");
        printSudoku(sudokuBoard);
    }

    public static void printSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}