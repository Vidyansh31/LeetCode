class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < nums.length-2; i++){
            int lo = i+1;
            int hi = nums.length-1;
            while(lo < hi){
                int currSum = nums[lo] + nums[hi] + nums[i];
                
                if(Math.abs(currSum - target) < diff){
                    diff = Math.abs(currSum - target);
                    ans = currSum;
                }
                
                if(currSum < target){
                    lo++;
                }
                else{
                    hi--;
                }
            }
        }
        
        return ans;
    }
}