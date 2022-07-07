class Solution {
    public int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        boolean[][] vis = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == first){
                    boolean ans = helper(board, i , j , word, 0, vis);
                    if(ans){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, int i , int j , String word, int idx, boolean[][] vis){
        
        if(idx == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j] == true){
            return false;
        }
        
        
        
        if(board[i][j] != word.charAt(idx)){
            return false;
        }
        
        
        
        vis[i][j] = true;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            boolean recAns = helper(board,r,c,word,idx+1,vis);
            if(recAns){
                return true;
            }
            
        }
        
        vis[i][j] = false;
        
        return false;
    }
}