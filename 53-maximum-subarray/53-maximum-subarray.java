class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int LarSum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(currSum >= 0){
                currSum += nums[i];
            }
            else{
                currSum = nums[i];
            }
            
            if(currSum > LarSum){
                LarSum = currSum;
            }
        }
        
        return LarSum;
    }
}