class Solution {
    public void solve(char[][] board) {
        if(board.length <= 2 || board[0].length <= 2){
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        //Search for O at first col and last col
        //when founded convert it and its neighbour to *
        for(int i = 0; i < row ; i++){
            if(board[i][0] == 'O'){
                boundaryDFS(board,i,0);
            }
            if(board[i][col-1] == 'O'){
                boundaryDFS(board,i,col-1);
            }
        }
        
        //Search for O at first row and last row
        for(int j = 0; j < col ; j++){
            if(board[0][j] == 'O'){
                boundaryDFS(board,0,j);
            }
            if(board[row-1][j] == 'O'){
                boundaryDFS(board,row-1,j);
            }
        }
        
        //Traverse and change 'O' to 'X' then '*' to 'O'
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void boundaryDFS(char[][] b , int i , int j){
        if(i < 0 || i > b.length-1 || j < 0 || j > b[0].length-1 || b[i][j] != 'O'){
            return;
        }
        
        b[i][j] = '*';
        
        boundaryDFS(b,i-1,j);
        boundaryDFS(b,i,j+1);
        boundaryDFS(b,i+1,j);
        boundaryDFS(b,i,j-1);
        
    }
}