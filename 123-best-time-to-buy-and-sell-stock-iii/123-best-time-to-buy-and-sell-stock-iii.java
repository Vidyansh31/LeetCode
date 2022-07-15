class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][3];
        return helper(prices,0,1,2,dp);
    }
    
    private int helper(int[] p, int idx, int buy, int tcount,Integer[][][] dp ){
        
        if(idx == p.length || tcount == 0){
            return 0;
        }
        
        
        
        if(dp[idx][buy][tcount] != null){
            return dp[idx][buy][tcount];
        }
        
        int profit = 0;
        if(buy == 1){
            
            profit = Math.max(-p[idx]+helper(p,idx+1,0,tcount,dp),helper(p,idx+1,1,tcount,dp));
          
        }
        else{
            profit = Math.max(p[idx]+helper(p,idx+1,1,tcount-1,dp),helper(p,idx+1,0,tcount,dp));
        }
        
        
        return dp[idx][buy][tcount]= profit;
    }
}