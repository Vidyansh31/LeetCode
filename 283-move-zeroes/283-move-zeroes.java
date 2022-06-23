class Solution {
    public void moveZeroes(int[] nums) {
        int lastFoundZeroAt = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastFoundZeroAt++] = nums[i];
            }
        }
        
        for(int i = lastFoundZeroAt; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}