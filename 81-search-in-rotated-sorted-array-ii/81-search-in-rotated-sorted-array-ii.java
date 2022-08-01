class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo <= hi){
            //Avoid Duplicates
            while(lo < hi && nums[lo] == nums[lo+1]){
                lo++;
            }
            
            while(lo < hi && nums[hi] == nums[hi-1]){
                hi--;
            }
            
            //Now this question is same as Search in Rotated Array
            int mid = (hi+lo)/2;
            
            if(nums[mid] == target){
                return true;
            }
            
            if(nums[lo] <= nums[mid]){
                if(target >= nums[lo] && nums[mid] > target){
                    hi = mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            else{
                 if(target <= nums[hi] && nums[mid] < target){
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