class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo <= hi){
            //avoiding duplicates
            while(lo < hi && nums[lo] == nums[lo+1]){
                lo++;
            }
            
            while(lo < hi && nums[hi-1] == nums[hi]){
                hi--;
            }
            
            //Now this is same as Search in rotated Array
            int mid = (lo+hi)/2;
            
            if(nums[mid] == target){
                return true;
            }
            else if(nums[lo] <= nums[mid]){ // low to high is sorted
                if(nums[lo] <= target && nums[mid] > target){
                     hi = mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            else{
                if(nums[hi] >= target && nums[mid] < target){ // mid to high is sorted
                     lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
            
        }
        
        return false;
    }
}