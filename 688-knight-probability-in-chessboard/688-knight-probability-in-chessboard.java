class Solution {
    public double knightProbability(int n, int k, int row, int column) {
         double[][][] dp = new double[n][n][k+1];
        dp[row][column][0] = 1.0;
        
        int[][] dir = {{-2,1} , {-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
        
        for(int move = 1; move <= k; move++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    
                        for(int[] d : dir){
                            int x = i + d[0];
                            int y = j + d[1];
                            
                            if(x >= 0 && x < n && y >= 0 && y < n){
                                dp[x][y][move] += dp[i][j][move-1] / 8;
                            }
                        }  
                    
                }
            }
        }
        
        double res = 0;
        
         for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    res += dp[i][j][k];
                }
         }
        
        return res;
    }
}