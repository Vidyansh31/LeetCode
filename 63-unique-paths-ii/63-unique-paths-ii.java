class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length-1;
        int m = obstacleGrid[0].length-1;
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if(i == 0 && j == 0){
                    //their is only 1 way to reach (0,0) from (0,0);
                     dp[i][j] = 1;
        
                }
                else if(i == 0){
                    dp[i][j] = dp[i][j-1];
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        
        
        return dp[n][m];
        
    }
    
   
}