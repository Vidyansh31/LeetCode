class Solution {
    public boolean isPerfectSquare(int num) {
        long high = 100000;
        long low = 1;
        
        while(low <= high){
            long mid = low + (high-low)/2;
            // System.out.println(mid);
            if(mid*mid == num){
                return true;
            }
            else if(mid*mid < num){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        
        
        return false;
    }
}