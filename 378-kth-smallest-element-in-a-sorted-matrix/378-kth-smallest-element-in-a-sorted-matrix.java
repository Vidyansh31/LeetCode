class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        int ans = 0;
        while(lo <= hi){
            int mid =(hi+lo)/2;
            
            if(countLessOrEqual(mid, matrix) >= k){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    
    private int countLessOrEqual(int num, int[][] m){
        int count = 0;
        int c = m.length-1;
        
        for(int i = 0; i < m.length && c >= 0 ; i++){
            
            while( c >= 0 && m[i][c] > num) c--;
            count += c+1;
        }
        
        return count;
    }
}