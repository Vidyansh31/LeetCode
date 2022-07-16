class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp= new int[n];
        Arrays.fill(dp,1);
        
        for(int i = 1; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[i] > nums[prev]){
                    dp[i] = Math.max(1 + dp[prev],dp[i]);
                }
            }
        }
        
        int ans = 0;
        for(int len : dp){
            if(len > ans){
                ans = len;
            }
        }
        
        return ans;
    }
    
   
}