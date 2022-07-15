class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //total 4 transaction - B S B S
        int[][] dp = new int[n+1][5];
        
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= 3; j++){
                int profit = 0;
                if(j%2 == 0){
                    profit = Math.max(-prices[i]+dp[i+1][j+1], dp[i+1][j]);
                }
                else{
                     profit = Math.max(prices[i]+dp[i+1][j+1], dp[i+1][j]);
                }

                 dp[i][j] =  profit;
            }
        }
        
        
        return dp[0][0];
    }
    
    
}