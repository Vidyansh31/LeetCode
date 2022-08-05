class Solution {
    public int splitArray(int[] nums, int m) {
        int hi = 0;
        int lo = Integer.MIN_VALUE;
        for(int num : nums){
            lo = Math.max(lo,num);
            hi += num;
        }
        
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            
            int partition = count(nums,mid);
            
            if(partition > m){
                lo = mid+1;
            }
            else {
                
                hi = mid;
            }
        }
        
        return lo;
    }
    
    public int count(int[] nums, int sum){
        int s = 0;
        int part = 1;
        for(int num : nums){
            if(s + num <= sum){
                s += num;
            }
            else{
                s = num;
                part++;
            }
        }
        
        return part;
    }
}