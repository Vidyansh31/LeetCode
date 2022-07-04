class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        
       int[] dp = new int[nums.length];
        int temp = 0;
        dp[0] = nums[0]; 
        
        for(int i = 1; i < dp.length; i++){
            dp[i] = Math.max(temp+nums[i],dp[i-1]);
            temp = dp[i-1];
        }
        
        return dp[nums.length-1];
        
    }
}