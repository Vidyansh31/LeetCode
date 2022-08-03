class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] right = new int[nums.length];
        right[nums.length-1] = nums[nums.length-1];
        
        for(int i = nums.length-2; i >= 0; i--){
            right[i] = Math.min(right[i+1],nums[i]);
        }
        
    
        int currMax = -1;
        for(int i = 0; i < nums.length-1; i++){
            currMax = Math.max(currMax,nums[i]);
            
            if(currMax <= right[i+1]){
                return i+1;
            }
        }
        
        return -1;
    }
}