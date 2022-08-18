class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        int ans = 0;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            
            if(countLessOrEqual(mid,matrix) >= k){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    
    public int countLessOrEqual(int num, int[][] matrix){
        int c = matrix[0].length-1;
        int count = 0;
        for(int i = 0; i < matrix.length && c >= 0; i++){
            
            while(c >= 0 && matrix[i][c] > num) c--;
            
            count += c+1;
        }
        
        return count;
    }
}