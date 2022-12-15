class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for(int i = 1; i < n; i++){
            int take = nums[i];
            if(i > 1) take += dp[i-2];
            
            int notTake = dp[i-1];
            
            dp[i] = Math.max(take, notTake);
        }
        
        
        return dp[n-1];
    }
    
    
}