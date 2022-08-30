class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        
        return helper(prices,0,1,dp,fee);
    }
    
     public int helper(int[] prices, int idx, int buy, int[][] dp, int fee){
        if(idx == prices.length){
            return 0;
        }
        
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }
        
        int profit1 = 0;
        
        
        if(buy == 1){
            profit1 = Math.max(-prices[idx]+ helper(prices,idx+1,0,dp,fee), helper(prices, idx+1,1,dp,fee));
        }
        else{
            profit1 = Math.max(+prices[idx]-fee+helper(prices,idx+1,1,dp,fee),helper(prices, idx+1, 0,dp,fee));
        }
        
        return dp[idx][buy] = profit1;
    }
}