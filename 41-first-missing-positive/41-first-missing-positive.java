class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > n || nums[i] <= 0){
                nums[i] = n+1;
            }
        }
        
        
        for(int i = 0; i < n; i++){
            int val = Math.abs(nums[i]);
            if(val >= n+1){
                continue;
            }
            
            int idx = val-1;
            
            if(nums[idx] > 0){
                nums[idx] = -1*nums[idx];
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        
        return n+1;
    }
}