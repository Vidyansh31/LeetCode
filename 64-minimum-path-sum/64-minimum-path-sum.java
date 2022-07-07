class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] dp = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }
                else if(i == 0 ){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }
                else if(j == 0 ){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }
                else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
        
    }
    
    private int helper(int[][] grid,int sr, int sc, int dr, int dc,int[][] dp){
        if(sr > dr || sc > dc){
            return Integer.MAX_VALUE;
        }
        if(sr==dr && sc == dc){
            return grid[sr][sc];
        }
        if(dp[sr][sc] != -1){
            return dp[sr][sc];
        }
        int right = helper(grid,sr,sc+1,dr,dc,dp);
        int down = helper(grid,sr+1,sc,dr,dc,dp);
        
        
        return dp[sr][sc] =  grid[sr][sc] + Math.min(right,down);
       
    }
}