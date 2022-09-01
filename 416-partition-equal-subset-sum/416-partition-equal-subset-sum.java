class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum%2 == 1){
            return false;
        }
        
        sum = sum/2;
        
        boolean[] prev = new boolean[sum+1];
        
//         for(int i = 0; i < dp.length; i++){
//             dp[i][0] = true;
//         }
        
//         for(int i = 1; i < dp[0].length; i++){
//             dp[0][i] = false;
//         }
        prev[0] = true;
        
        for(int i = 1; i <= nums.length; i++){
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            for(int j = 1; j <= sum; j++){
                boolean notPick = prev[j];
                
                boolean pick = false;
                
                if(j >= nums[i-1]) pick = prev[j-nums[i-1]];
                
                curr[j] = pick || notPick;
            }
            prev = curr;

        }
        
       return prev[sum];
    }
}