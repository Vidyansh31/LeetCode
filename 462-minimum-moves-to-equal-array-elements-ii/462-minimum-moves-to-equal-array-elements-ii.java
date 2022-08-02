class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        //Find median
        int low = 0;
        int high = nums.length-1;
        int count = 0;
        while(low < high){
            count += nums[high] - nums[low];
            low++;
            high--;
        }
        
        return count;
    }
}