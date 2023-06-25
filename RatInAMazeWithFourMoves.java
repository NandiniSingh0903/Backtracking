public class RatInAMazeWithFourMoves {
    //need to check block area
    static boolean isNotBlocked(int board[][], int row, int col){
        if(row<board.length && col<board[row].length && board[row][col]==1){
            return true;
        }
        return false;
    }

    static boolean ratInAMaze(int board[][], int row, int col, int[][] path){
        if(row<0 || col<0 || row>=board.length || col>=board.length || path[row][col]==1 || board[row][col]==0){
            return false;
        }

        if(row==board.length-1 && col==board.length-1){
            path[row][col]=1;
            return true;
        }

        if(isNotBlocked(board, row, col)){
            path[row][col]=1;

            //to move down
            if(ratInAMaze(board, row+1, col, path)){
                return true;
            }

            //to move right
            if(ratInAMaze(board, row, col+1, path)){
                return true;
            }

            //to move up
            if(ratInAMaze(board, row-1, col, path)){
                return true;
            }

            //to move left
            if(ratInAMaze(board, row, col-1, path)){
                return true;
            }

            path[row][col]=0;
        }

        return false;
    }

    public static void main(String args[]){
        int board[][] ={
            {1,0,1,0,1},
            {1,1,1,0,1},
            {0,1,0,1,0},
            {1,1,0,1,1},
            {1,1,1,1,1}
        };
        int path[][] = new int[board.length][board.length]; //filled with 0
        boolean result = ratInAMaze(board, 0, 0, path);
        if(result){
            System.out.println("Rat reached");
            for(int i=0;i<path.length;i++){
                for(int j=0;j<path.length;j++){
                    System.out.print(path[i][j]+" ");
                }
                System.out.println();
            }
        }

        else{
            System.out.println("Rat not reached");
        }
    }
}
