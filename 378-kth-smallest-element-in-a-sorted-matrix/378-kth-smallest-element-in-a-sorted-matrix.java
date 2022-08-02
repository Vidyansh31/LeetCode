class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        int ans = 0;
        while(lo <= hi){
            int mid = (lo+hi) >> 1;
            
            if(countLessOrEqual(matrix, mid) >= k){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    
    public int countLessOrEqual(int[][] mat, int x){
        int count = 0; 
        int c = mat.length-1;
        
        for(int i = 0; i < mat.length; i++){
            while(c >= 0 && mat[i][c] > x) c--;
            count += (c+1);
        }
        return count;
    }
}