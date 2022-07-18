class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp  = new int[m][n];
        
        for(int i = 0,j = 0; j< n; j++){
            dp[i][j] = matrix[i][j];
        }
        
        for(int j = 0,i = 0; i < m; i++){
            dp[i][j] = matrix[i][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0) dp[i][j] = 0;
                else dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
            }
        }
        
        
        int count = 0;
        for(int[] row : dp){
            for(int val : row){
                count += val; 
            }
        }
        
        return count;
    }
}