class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int ans = 1;
        
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = 1 + dp[i-1];
            }
            
            ans = Math.max(dp[i],ans);
        }
        
        return ans;
    }
}