class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];
        return helper(nums,0,-1,dp);
    }
    
    public int helper(int[] nums, int idx, int prev_idx, Integer[][] dp){
        if(idx == nums.length){
            return 0;
        }
        
        if(dp[idx][prev_idx+1] != null){
            return dp[idx][prev_idx+1];
        }
        
        int NotPick = helper(nums,idx+1,prev_idx,dp);
        int pick = Integer.MIN_VALUE;
        
        if(prev_idx == -1 || nums[prev_idx] < nums[idx]) pick = 1 + helper(nums,idx+1,idx,dp);
        
        
        return dp[idx][prev_idx+1] = Math.max(pick,NotPick);
        
    }
}