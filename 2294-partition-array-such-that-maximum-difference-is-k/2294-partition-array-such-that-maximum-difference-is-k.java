class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = nums[nums.length-1];
        int count = 1;
        for(int i = nums.length-2; i >= 0; i--){
            if(prev - nums[i] > k){
                prev = nums[i];
                count++;
            } 
        }
        
        return count;
    }
}