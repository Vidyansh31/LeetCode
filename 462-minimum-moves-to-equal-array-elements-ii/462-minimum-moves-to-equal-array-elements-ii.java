class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        //Find median
        int low = 0;
        int high = nums.length-1;
        
        int mid = low + (high-low)/2;
        
        int median = nums[mid];
        
        int count = 0;
        for(int num : nums){
            count += Math.abs(num-median);
        }
        
        return count;
    }
}