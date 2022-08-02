class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            
            while(lo < hi && nums[lo]%2 == 0){
                lo++;
            }
            
            while(lo < hi && nums[hi]%2 != 0){
                hi--;
            }
            
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
        
        return nums;
    }
}