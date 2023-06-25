public class LeetcodeWordSearch {
    public static boolean exist(char[][] board, String word) {
        int[][] picked = new int[board.length][board[0].length];
        for(int i=0;i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]== word.charAt(0)){
                    if(isFound(i, j, board, word, 0, picked)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean isFound(int i, int j, char [][] board, String word, int k, int[][]picked){
        if(k==word.length()){
            return true;
        }

        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j] != word.charAt(k) || picked[i][j]==1){
            return false;
        }

        picked[i][j]=1;
        char ch = board[i][j];
        boolean r1 = isFound(i+1, j, board, word, k+1, picked);
        boolean r2 = isFound(i-1, j, board, word, k+1, picked);
        boolean r3 = isFound(i, j+1, board, word, k+1, picked);
        boolean r4 = isFound(i, j-1, board, word, k+1, picked);
        picked[i][j] = 0;
        return r1 || r2|| r3|| r4;
    }

    public static void main(String[] args) {
        char board[][] = {
                        {'A','B','C','D'},
                        {'S','F','C','S'},
                        {'A','D','E','E'},
                    };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}