class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        int max = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                
                if(i == 0){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else if(j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i][j-1])) + (matrix[i][j] - '0');
                }
                
                
                max = Math.max(dp[i][j], max);
            }
            
        }
        
        return max*max;
    }
}