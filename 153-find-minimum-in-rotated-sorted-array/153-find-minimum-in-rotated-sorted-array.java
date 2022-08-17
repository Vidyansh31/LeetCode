class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo < hi){
            int mid = (lo+hi)/2;
            
            //if nums[mid] is greater than nums[hi] we will get our ans between mid+1 and hi
            if(nums[mid] > nums[hi]){
                lo = mid+1;
            }
            else{
                //else we get our answer from lo to mid;
                hi = mid;
                
            }
        }
        
        return nums[lo];
    }
}