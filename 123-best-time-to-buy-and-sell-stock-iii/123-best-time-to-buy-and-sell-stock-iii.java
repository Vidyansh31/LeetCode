class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        
       
        
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                for(int k = 2; k >= 1; k--){
                    int profit = 0;
                    if( j == 1){
                        profit = Math.max(-prices[i]+dp[i+1][j-1][k],dp[i+1][j][k]);

                    }
                    else{
                         profit = Math.max(prices[i]+dp[i+1][j+1][k-1],dp[i+1][j][k]);
                    }


                    dp[i][j][k]= profit;
                }
            }
        }
        
        
        return dp[0][1][2];
    }
    
    
}