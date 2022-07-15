class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //total 4 transaction - B S B S
        Integer[][] dp = new Integer[n][4];
        return helper(prices,0,0,dp);
    }
    
    private int helper(int[] p , int idx, int trans,Integer[][] dp){
        
        if(idx == p.length || trans == 4){
            return 0;
        }
        
        if(dp[idx][trans] != null){
            return dp[idx][trans];
        }
        
        int profit = 0;
        if(trans%2 == 0){
            profit = Math.max(-p[idx]+helper(p,idx+1,trans+1,dp),helper(p,idx+1,trans,dp));
        }
        else{
            profit = Math.max(p[idx]+helper(p,idx+1,trans+1,dp),helper(p,idx+1,trans,dp));
        }
        
        return dp[idx][trans] =  profit;
    }
}