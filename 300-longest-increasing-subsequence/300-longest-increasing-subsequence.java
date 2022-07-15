class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n+1];
        return helper(nums,0,-1,dp);
    }
    
    private int helper(int[] nums, int i, int prev_i,Integer[][] dp){
        
        if(i == nums.length){
            return 0;
        }
        
        if(dp[i][prev_i+1] != null){
            return dp[i][prev_i+1];
        }
        
        //not take
        int l1 = helper(nums, i+1,prev_i,dp);
        
        int l2 = 0;
        
        if(prev_i == -1 || nums[i] > nums[prev_i]){
            l2 = 1 + helper(nums,i+1,i,dp);
        }
        
        return dp[i][prev_i+1] = Math.max(l1,l2);
    }
}