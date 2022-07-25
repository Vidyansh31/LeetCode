class Solution {
    public int[] searchRange(int[] nums, int target) {
        
       int[] ans = new int[2];
        ans[0] = lowerBound(nums,target);
        ans[1] = upperBound(nums,target);
        
        return ans;
    }
    
    public int lowerBound(int[]a,int target){
        int low = 0;
        int high = a.length-1;
        int rv = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]==target){
                rv = mid;
                high = mid - 1;
            }
            else if(a[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return rv;
    }
       public int upperBound(int[]a,int target){
        int low = 0;
        int high = a.length-1;
        int rv = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(a[mid]==target){
                rv = mid;
                low = mid + 1;
            }
            else if(a[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return rv;
    }
}