class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] tmatrix = new int[n][m];
        
        int col = 0;
        for(int[] row : matrix){
            int idx = 0;
            for(int i = 0; i < tmatrix.length; i++){
                tmatrix[i][col] = row[idx++];
            }
            col++;
        }
        
        return tmatrix;
    }
}