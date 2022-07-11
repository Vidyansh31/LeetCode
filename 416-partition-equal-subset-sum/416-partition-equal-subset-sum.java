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
        
        boolean[] prev = new boolean[sum+1];
        prev[0] = true;
        
        
        
        for(int i = 1; i < nums.length; i++){
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            for(int j = 1; j <= sum; j++){
                 boolean notPick = prev[j];
                 boolean pick = false;

                 if(nums[i] <= j){
                    pick = prev[j-nums[i]];
                 }

                 curr[j] =  pick || notPick;
            }
            
            prev = curr;
        }
        
        return prev[sum];
        
    }
    
    
}