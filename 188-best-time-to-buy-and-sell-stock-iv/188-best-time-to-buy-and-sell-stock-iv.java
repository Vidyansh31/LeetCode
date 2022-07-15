class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][k+1];
        
        return helper(prices, 0, 1,k,dp);
    }
    
    private int helper(int[] p , int i, int buy, int k, Integer[][][] dp){
        
        if(i == p.length || k == 0){
            return 0;
        }
        
        if(dp[i][buy][k] != null){
            return dp[i][buy][k];
        }
        
        int profit = 0;
        
        if(buy == 1){
            profit = Math.max(-p[i]+helper(p,i+1,0,k,dp),helper(p,i+1,1,k,dp));
        }
        else{
            profit = Math.max(p[i]+helper(p,i+1,1,k-1,dp),helper(p,i+1,0,k,dp));
        }
        
        return dp[i][buy][k] = profit;
    }
}