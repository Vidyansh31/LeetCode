class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][k+1];
        return helper(prices,0,1,k,dp);
    }
    
    public int helper(int[] arr, int idx, int buy, int k, Integer[][][] dp){
        if(idx == arr.length){
            return 0;
        }
        
        if(dp[idx][buy][k] != null){
            return dp[idx][buy][k];
        }
        
        if(k == 0){
            return 0;
        }
        
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[idx]+ helper(arr,idx+1,0,k,dp), helper(arr,idx+1,1,k,dp));
        }
        else{
            profit = Math.max(arr[idx] + helper(arr,idx+1,1,k-1,dp), helper(arr,idx+1,0,k,dp));
        }
        
        return dp[idx][buy][k] = profit;
    }
}