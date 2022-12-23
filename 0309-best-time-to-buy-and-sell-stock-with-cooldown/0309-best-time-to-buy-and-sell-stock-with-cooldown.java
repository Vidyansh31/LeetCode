class Solution {
    public int maxProfit(int[] prices) {
          int[][] dp = new int[prices.length][2];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return helper(prices,0,1,dp);
    
    }
    
     public int helper(int[] prices, int idx, int buy, int[][] dp){
        if(idx >= prices.length){
            return 0;
        }
        
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }
        
        int profit1 = 0;
        
        
        if(buy == 1){
            profit1 = Math.max(-prices[idx]+ helper(prices,idx+1,0,dp), helper(prices, idx+1,1,dp));
        }
        else{
            profit1 = Math.max(+prices[idx]+helper(prices,idx+2,1,dp),helper(prices, idx+1, 0,dp));
        }
        
        return dp[idx][buy] = profit1;
     }
}