class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        for(int i = 0; i < nums.length-1; i++){
            lo = Math.min(lo,nums[i+1]-nums[i]);
        }
        int hi = nums[nums.length-1]-nums[0];
        
        while(lo < hi){
            int mid = (lo+hi)/2;
            
            if(countLessOrEqual(mid,nums) >= k){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        
        return lo;
    }
    
    
    public int countLessOrEqual(int mid, int[] nums){
        int count = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while(j < nums.length && nums[j]-nums[i] <= mid) j++;
            
            count += j-i-1;
        }
        
        return count;
    }
}