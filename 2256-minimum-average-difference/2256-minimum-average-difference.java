class Solution {
    public int minimumAverageDifference(int[] nums) {
        long prefixSum = 0;
        
        for(int num : nums){
            prefixSum += num;
        }
        
        int len = nums.length;
        long min = Long.MAX_VALUE;
        int ans = 0;
        long leftSum = 0;
        long rightSum = 0;
        for(int i = 0; i < nums.length; i++){
            leftSum += nums[i];
            rightSum = prefixSum - leftSum;
            
            long diff = Math.abs(leftSum/(i+1) - (len-i == 1 ? 0 : rightSum/(len-i-1)));
            
            if(diff < min){
                min = diff;
                ans = i;
            }
        }
        
        return ans;
        
    }
}