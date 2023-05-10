class Solution {
    public int[][] generateMatrix(int n) {
        int totalEle = n*n;
        int row_st = 0;
        int row_end = n-1;
        int col_st = 0;
        int col_end = n-1;
        
        int[][] res = new int[n][n];
        
        int currEle = 1;
        
        while(currEle <= totalEle){
            for(int j = col_st; j <= col_end && currEle <= totalEle; j++){
                res[row_st][j] = currEle++;
            }
            row_st++;
            
            for(int i = row_st; i <= row_end && currEle <= totalEle; i++){
                res[i][col_end] = currEle++;
            }
            col_end--;
            
            for(int j = col_end; j >= col_st && currEle <= totalEle; j--){
                res[row_end][j] = currEle++;
            }
            row_end--;
            
            for(int i = row_end; i >= row_st && currEle <= totalEle; i--){
                res[i][col_st] = currEle++;
            }
            col_st++;
            
        }
        
        return res;
        
        
    }
}