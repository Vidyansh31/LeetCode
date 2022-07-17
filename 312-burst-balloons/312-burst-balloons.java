class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] num = new int[n+2];
        num[0] = 1;
        for(int i = 1; i <= n; i++){
            num[i] = nums[i-1];
        }
        num[n+1] = 1;
        Integer[][] dp = new Integer[n+2][n+2];
        return helper(1,n,num,dp);
    }
    
    private int helper(int st, int end, int[] nums, Integer[][] dp){
        if(st > end){
            return 0;
        }
        
        if(dp[st][end] != null){
            return dp[st][end];
        }
        
        int maxCoin = Integer.MIN_VALUE;
        
        for(int k = st; k <= end; k++){
            int prev = nums[st-1];
            int next = nums[end+1];
            
            int coin = prev*nums[k]*next + helper(st,k-1,nums,dp) + helper(k+1,end,nums,dp);
            
            maxCoin = Math.max(coin,maxCoin);
        }
        
        return dp[st][end] = maxCoin;
    }
}