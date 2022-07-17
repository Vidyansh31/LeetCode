class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] num = new int[n+2];
        num[0] = 1;
        for(int i = 1; i <= n; i++){
            num[i] = nums[i-1];
        }
        num[n+1] = 1;
        int[][] dp = new int[n+2][n+2];
        
        for(int i = n; i >= 1; i--){
            for(int j = 1; j<=n; j++){
                if(i > j){
                    continue;
                }
                
                int maxCoin = Integer.MIN_VALUE;
                for(int k = i; k <= j ; k++){
                    int coin = num[i-1]*num[k]*num[j+1] + dp[i][k-1] + dp[k+1][j];
                    maxCoin = Math.max(coin,maxCoin);
                }
                
                dp[i][j] = maxCoin;
            }
        }
        return dp[1][n];
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