class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        Integer[][]dp = new Integer[n][2*k+1];
        
        return helper(prices, 0,0,2*k,dp);
    }
    
    private int helper(int[] p , int i, int k,int cap, Integer[][] dp){
        
        if(i == p.length || k == cap){
            return 0;
        }
        
        if(dp[i][k] != null){
            return dp[i][k];
        }
        
        int profit = 0;
        
        if(k%2 == 0){
            profit = Math.max(-p[i]+helper(p,i+1,k+1,cap,dp),helper(p,i+1,k,cap,dp));
        }
        else{
            profit = Math.max(p[i]+helper(p,i+1,k+1,cap,dp),helper(p,i+1,k,cap,dp));
        }
        
        return dp[i][k] = profit;
    }
}