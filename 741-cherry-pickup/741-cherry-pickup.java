class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][][] dp = new int[grid.length][grid[0].length][grid.length][grid[0].length];
        int ans = helper(grid,0,0,0,0,dp);
        if(ans < 0){
            return 0;
        }
        return ans;
    }
    
    private int helper(int[][] grid, int r1, int c1, int r2, int c2, int[][][][] dp){
        if(r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >=grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1){ 
            return -(int)1e9;
        }
        
        
        if(r1 == grid.length-1 && c1 == grid[0].length-1){
            return grid[r1][c1];
        }
        
        if(dp[r1][c1][r2][c2] != 0){
            return dp[r1][c1][r2][c2];
        }
        
        int cherries = 0;
        if(r1 == r2 && c1 == c2){
            cherries += grid[r1][c1];
        }
        else{
            cherries += grid[r1][c1]+grid[r2][c2];
        }
        
        
        
        int f1 = helper(grid,r1,c1+1,r2,c2+1,dp);
        int f2 = helper(grid,r1,c1+1,r2+1,c2,dp);
        int f3 = helper(grid,r1+1,c1,r2,c2+1,dp);
        int f4 = helper(grid,r1+1,c1,r2+1,c2,dp);
        
        return dp[r1][c1][r2][c2] = cherries + Math.max(Math.max(f1,f2), Math.max(f3,f4));
    }
}