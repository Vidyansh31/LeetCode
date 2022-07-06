class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int ans1 = helper(dp,nums,nums.length-2,0);
        Arrays.fill(dp,-1);
        int ans2 = helper(dp,nums,nums.length-1,1);     
        
        return Math.max(ans1,ans2);
    }
    
    public int helper(int[] dp,int[] arr, int idx, int endPoint ){
        if(idx == endPoint){
            return arr[idx];
        }
        if(idx < endPoint){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int pick = arr[idx] + helper(dp,arr,idx-2,endPoint);
        int notpick =  helper(dp,arr,idx-1,endPoint);
        
        return dp[idx] = Math.max(pick,notpick);
        
    }
}