class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        int rv = -1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                rv = mid+1;
                lo = mid+1;
            }
            else{
                rv = mid;
                hi = mid-1;
            }
            
        }
        
        return rv;
    }
}