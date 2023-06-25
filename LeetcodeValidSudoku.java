public class LeetcodeValidSudoku{
    private static boolean isNumberInRow(char[][] board, char num, int row, int col){
        for(int i=0;i<9;i++){
            if(col!=i && board[row][i]==num){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInCol(char[][] board, char num, int row, int col){
        for(int i=0;i<9;i++){
            if(row!=i && board[i][col] == num){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInSubGrid(char board[][], char num, int row, int col){
        int gridRow = row - row%3;
        int gridCol = col - col%3;
        for(int i=gridRow; i<gridRow+3; i++){
            for(int j=gridCol; j<gridCol+3; j++){
                if(row!=i && col!=j && board[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(char[][] board, char num, int row, int col){
        return  !isNumberInRow(board, num, row, col) &&
                !isNumberInCol(board, num, row, col) &&
                !isNumberInSubGrid(board, num, row, col);
    }
    
    public static boolean isValidSudoku(char[][] board) {
        for(int row=0; row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]!='.' && !isValidPlacement(board, board[row][col], row, col)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char board[][] = {
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
        System.out.println(isValidSudoku(board));
    }
}