class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return helper(prices,0,1,dp);
    }
    
    private int helper(int[] p, int idx, int buy,Integer[][] dp){
        //buy --> 0 not allowed buy
        // buy --> 1 allowed buy
        
        if(idx == p.length){
            return 0;
        }
        
        if(dp[idx][buy] != null){
            return dp[idx][buy];
        }
        
        int p1= 0;
        if(buy == 1){
            //buying possibilites
            p1 = Math.max(-p[idx]+helper(p,idx+1,0,dp),helper(p,idx+1,1,dp));
        }
        else{
            //not buying possibilites
            p1 = Math.max(p[idx]+helper(p,idx+1,1,dp),helper(p,idx+1,0,dp));
        }
        
        return dp[idx][buy] = p1;
    }
}