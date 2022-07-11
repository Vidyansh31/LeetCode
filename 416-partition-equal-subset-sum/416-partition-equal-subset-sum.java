class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum%2 != 0){
            return false;
        }
        //we just have to search for a subset whose sum is equal to sum/2;
        
        sum = sum/2;
        
        boolean[][] dp = new boolean[nums.length][sum+1];
        
        //base cases when tar == 0 then it is true;
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }
        //2nd case when we are on zero index and we have to search for nums[0] we store true;
        // dp[0][nums[0]] = true;
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j <= sum; j++){
                 boolean notPick = dp[i-1][j];
                 boolean pick = false;

                 if(nums[i] <= j){
                    pick = dp[i-1][j-nums[i]];
                 }

                 dp[i][j] =  pick || notPick;
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
        
    }
    
    
}