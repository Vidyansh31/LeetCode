class Solution {
    public int findMiddleIndex(int[] nums) {
        int rightSum = 0;
        for(int i : nums){
            rightSum += i;
        }
        
        int leftSum = 0;
        int pivotIndex = 0;
        
        while(pivotIndex < nums.length){
            rightSum -= nums[pivotIndex];
            
            if(leftSum == rightSum){
                return pivotIndex;
            }
            
            leftSum += nums[pivotIndex];
            pivotIndex++;
        }
        
        return -1;
    }
}