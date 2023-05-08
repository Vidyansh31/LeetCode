class Solution {
    public int diagonalSum(int[][] mat) {
       int i = 0;
        int j = 0;
        int k = mat[0].length-1;
        
        int res = 0;
        
        while(i < mat.length){
            
            
            if(j == k){
                res += mat[i][j];
            }
            else{
                res += mat[i][j] + mat[i][k];
            }
            
            i++;
            j++;
            k--;
        }
        
        return res;
    }
}