class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        for(int i = 0; i < nums.length-1; i++){
            lo = Math.min(lo,nums[i+1]-nums[i]);
        }
        int hi = nums[nums.length-1] - nums[0];
        
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            
            if(countGapsLessOrEqual(nums,mid) >= k){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        
        return hi;
        
    }
    
    public int countGapsLessOrEqual(int[] nums, int mid){
        int count = 0;
        
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] - nums[i] <= mid){
                    count++;
                }
            }
        }
        
        return count;
    }
}