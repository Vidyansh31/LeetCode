class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int i = n; i >= 0; i--){
            for(int j = m; j >= 0; j--){
                if(i == n){
                    dp[i][j] = matrix[i][j];
                }
                else if(j == m){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j-1]);
                }
                else if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
                else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i+1][j-1]));
                }
                
            }
        }
        
        int i = 0;
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j <= m; j++){
            ans = Math.min(dp[i][j],ans);
        }
        
        return ans;
    }
    
    
}