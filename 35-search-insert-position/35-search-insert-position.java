class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        int rv = -1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] < target){
                low = mid + 1;
                rv = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid -1;
                rv = mid;
            }
            else{
                return mid;
            }
        }
        
        return rv;
    }
}