class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[dp.length-1] = prices[prices.length-1];
        
        for(int i = dp.length - 2; i >= 0; i--){
            dp[i] = Math.max(prices[i],dp[i+1]);
        }
        
       
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            int profit = dp[i] - prices[i];
            maxProfit = Math.max(profit,maxProfit);
        }
        
        return maxProfit;
    }
}