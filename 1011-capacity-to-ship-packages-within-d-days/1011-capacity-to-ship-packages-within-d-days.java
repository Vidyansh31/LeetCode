class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        
        for(int w : weights){
            lo = Math.max(lo,w);
            hi += w;
        }
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            
            int requiredDays = count(weights,mid);
            
            if(requiredDays <= days){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        
        return hi;
    }
    
    private int count(int[] w, int days){
        int sum = 0;
        int day = 1;
        for(int wt: w){
            if(sum + wt <= days){
                sum += wt;
            }
            else{
                sum = wt;
                day++;
            }
        }
        
        return day;
    }
}