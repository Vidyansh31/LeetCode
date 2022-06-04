class Solution {
    public List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        if(n == 1){
            List<String> myans = new ArrayList<>();
            myans.add("Q");
            ans.add(myans);
            return ans;
        }
        
        if(n == 2 || n == 3){
            return ans;
        }
        
        int[][] chess = new int[n][n];
        placeQueen(chess,0);
        
        return ans;
    }
    
    public void placeQueen(int[][] chess , int row){
        if(row == chess.length){
            addToList(chess);
            return;
        }
        
        
        for(int col = 0; col < chess[0].length; col++){
            if(isQueenSafe(chess,row,col)){
                chess[row][col] = 1;
                placeQueen(chess,row+1);
                chess[row][col] = 0;
            }
        }
    }
    
    public boolean isQueenSafe(int[][] chess, int row, int col){
        //vertical check
        for(int i = row - 1, j = col; i >= 0; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        //left diagonal
        for(int i = row-1, j = col-1; i >=0 && j >= 0; i--, j--){
             if(chess[i][j] == 1){
                return false;
            }
        }
        
        //right diagonal
        for(int i = row-1, j = col+1; i >=0 && j < chess[0].length; i--, j++){
             if(chess[i][j] == 1){
                return false;
            }
        }
        
        return true;
    }
    
    public void addToList(int[][] chess ){
        
        List<String> rans = new ArrayList<>();
        for(int[] row : chess){
            String queen = new String("");
            for(int i = 0; i < row.length; i++){
                if(row[i] == 1){
                    queen += "Q";
                }
                else{
                    queen += ".";
                }
            }
            rans.add(queen);
            
        }
        
        
        ans.add(rans);
    }
}