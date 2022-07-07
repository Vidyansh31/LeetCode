class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(grid,0,0,grid.length-1, grid[0].length-1,dp);
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