class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m*n;
        int ans = 0;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            
            if(countLessOrEqual(mid, m,n) >= k){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        
        return lo;
    }
    
    private int countLessOrEqual(int num, int m, int n){
        int count = 0;
        int c = n;
        
        for(int i = 1; i <= m && c >= 1 ; i++){
            
            while( c >= 1 && i*c > num) c--;
            count += c;
        }
        
        return count;
    }
}