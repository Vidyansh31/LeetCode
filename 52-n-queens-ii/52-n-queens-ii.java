class Solution {
    public int count = 0;
    public int totalNQueens(int n) {
        
        if(n == 1){
            return 1;
        }
        
        int[][] chess = new int[n][n];
        placeQueens(chess,0);
        
        return count;
    }
    
    public void placeQueens(int[][] chess, int row){
        if(row == chess.length){
            count++;
            return;
        }
        
        for(int col = 0; col < chess[0].length; col++){
            if(isQueenSafe(chess,row,col)){
                chess[row][col] = 1;
                placeQueens(chess,row+1);
                chess[row][col] = 0;
            }
        }
    }
    
    public boolean isQueenSafe(int[][] chess , int row, int col){
        //vertical col
        for(int i = row-1, j = col; i >= 0; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        //left diagonal
        for(int i = row-1, j= col-1; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        //right diagonal
        for(int i = row-1, j= col+1; i >= 0 && j <chess[0].length ; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        return true;
    }
}