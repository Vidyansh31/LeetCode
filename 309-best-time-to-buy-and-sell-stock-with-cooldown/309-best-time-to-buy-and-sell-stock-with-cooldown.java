class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return helper(prices, 0,1,dp);
    }
    
    private int helper(int[] p, int i,int buy,Integer[][] dp){
        if(i >= p.length){
            return 0;
        }
        
        if(dp[i][buy] != null){
            return dp[i][buy];
        }
        
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-p[i]+helper(p,i+1,0,dp),helper(p,i+1,1,dp));
        }
        else{
            profit = Math.max(p[i]+helper(p,i+2,1,dp),helper(p,i+1,0,dp));
        }
        
        
        return dp[i][buy] = profit;
    }
}