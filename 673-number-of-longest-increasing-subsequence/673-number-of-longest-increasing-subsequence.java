class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] curr = new int[n];
        Arrays.fill(curr,1);
        int max = 1;
        
        
        for(int i = 1; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[i] > nums[prev] && dp[i] < 1+ dp[prev]){
                    dp[i] = 1 + dp[prev];
                    curr[i] =  curr[prev];
                }
                else if(nums[i] >= nums[prev] && dp[i] == 1 + dp[prev]){
                    curr[i] += curr[prev];
                }
            }
            
            if(max < dp[i]){
                max = dp[i];
                
            }
        }
       
        int nos = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == max) nos += curr[i];
        }
       
        
        return nos;
    }
}