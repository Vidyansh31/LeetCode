class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length-1;
        int m = obstacleGrid[0].length-1;
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(obstacleGrid,0,0,n,m,dp);
    }
    
    private int helper(int[][] grid, int sr, int sc, int dr, int dc,int[][] dp){
        if(sr > dr || sc > dc || grid[sr][sc] == 1){
            return 0;
        }
        
        if(sr == dr && sc == dc){
            return 1;
        }
        
        if(dp[sr][sc] != -1){
            return dp[sr][sc];
        }
        
        int right = helper(grid,sr,sc+1,dr,dc,dp);
        int left = helper(grid,sr+1,sc,dr,dc,dp);
        
        return dp[sr][sc] = right+left;
    }
}