class Solution {
    public int rob(int[] nums) {
        int n = nums.length-1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(nums,n,dp);
    }
    
    public int helper(int[] nums, int idx,int[] dp){
        if(idx < 0){
            return 0;
        }
        if(idx == 0){
            //yaha tbhi ayenge jb 1 pick nhi kara hoga
            return nums[0];
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        int pick = nums[idx] + helper(nums, idx-2,dp);
        int notPick = helper(nums,idx-1,dp);
        
        return  dp[idx] = Math.max(pick,notPick);
    }
}