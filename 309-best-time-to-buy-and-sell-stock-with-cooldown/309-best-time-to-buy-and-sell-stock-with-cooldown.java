class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        
        
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= 1; j++){
                int profit = 0;
                if(j == 1){
                    profit = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                else{
                    profit = Math.max(prices[i]+dp[i+2][1],dp[i+1][0]);
                }


                dp[i][j] = profit;
            }
        }
        
        
        return dp[0][1];
    }
    
    
}