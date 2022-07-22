class Solution {
    public int minMaxGame(int[] nums) {
        
        for(int n = nums.length; n > 1 ; n -= n/2){
            for(int i = 0; i < n/2; i++){
                nums[i] = i%2 == 1 ? Math.max(nums[2*i],nums[2*i+1]) : Math.min(nums[2*i],nums[2*i+1]);
            }
        }
        
        return nums[0];
    }
}