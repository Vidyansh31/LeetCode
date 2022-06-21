class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        for(int i : nums){
            rightSum += i;
        }
        
        int leftSum = 0;
        int pivotIndex = 0;
        
        // if(leftSum == rightSum){
        //     return pivotIndex;
        // }
        
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