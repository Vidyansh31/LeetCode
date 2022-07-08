class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int[][] a : dp){
            for(int[] row : a){
                Arrays.fill(row,-1);
            }
        }
        
        return helper(grid,0,0,grid[0].length-1,dp);
    }
    
    private int helper(int[][] grid, int r1, int c1, int c2, int[][][] dp){
        if(c1 < 0 || c2 < 0 || c1 >= grid[0].length || c2 >= grid[0].length){
            return -(int)1e9;
        }
        
        if(r1 == grid.length-1){
            if(c1 == c2){
                return grid[r1][c1];
            }
            else{
                return grid[r1][c1]+grid[r1][c2];
            }
        }
        
        if(dp[r1][c1][c2] != -1){
            return dp[r1][c1][c2];
        }
        
        int maxi = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(c1==c2){
                    int rec = grid[r1][c1] + helper(grid,r1+1,c1+i,c2+j, dp);
                    maxi = Math.max(rec,maxi);
                }
                else{
                    int rec = grid[r1][c1]+ grid[r1][c2] + helper(grid,r1+1,c1+i,c2+j,dp);
                    maxi = Math.max(rec,maxi);
                }
            }
        }
        
        return dp[r1][c1][c2] = maxi;
    }
}