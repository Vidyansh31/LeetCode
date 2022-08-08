class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] r : dp){
            Arrays.fill(r,-1);
        }
        return helper(nums,0,-1,dp);
    }
    
    private int helper(int[] nums, int idx, int prev, int[][] dp){
        
        if(idx == nums.length){
            return 0;
        }
        
        if(dp[idx][prev+1] != -1){
            return dp[idx][prev+1];
        }
        
        int notPick = helper(nums,idx+1,prev, dp);
        
        int pick = 0;
        
        if( prev == -1 || nums[prev] < nums[idx]) pick = 1 + helper(nums, idx+1,idx,dp);
        
        
        return dp[idx][prev+1] = Math.max(pick, notPick);
    }
}