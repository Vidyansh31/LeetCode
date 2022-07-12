class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        int X = (sum - target)/2;
        int n = nums.length;
        int[] prev = new int[X+1];
        
        if(nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        
        if(nums[0] != 0 && nums[0] <= X){
            prev[nums[0]] = 1;
        }
        
        for(int i = 1; i < n; i++){
            int[] curr = new int[X+1];
            for(int j = 0; j <= X; j++){
                int notTake =  prev[j];
                int take = 0;

                if(nums[i] <= j) take = prev[j-nums[i]];

                curr[j] = take + notTake;
            }
            
            prev = curr;
        }
        
        return prev[X];
    }
    
    
}