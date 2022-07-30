class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){
                        if(isValid(board,i,j,k)){
                            board[i][j] = k;
                            
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    
                    return false;
                }
                
            }
        }
        
        return true;
    }
    
    public boolean isValid(char[][] board, int r, int c, char ch){
        //horizontal check
        for(int i = 0; i < 9; i++){
            if(board[i][c] == ch){
                return false;
            }
        }
        
        //vertical check
        for(int j = 0; j < 9; j++){
            if(board[r][j] == ch){
                return false;
            }
        }
        
        //3*3 box check
        for(int i = 0; i < 9; i++){
            if(board[3 * (r/3 )+ i/3][3 * (c / 3) + i%3] == ch){
                return false;
            }
        }
        
        return true;
    }
}