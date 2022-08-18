class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
       int totalEle = matrix.length*matrix[0].length;
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;
        while(totalEle > 0){
            
            //left
            for(int j = colBegin; j <= colEnd && totalEle > 0; j++){
                res.add(matrix[rowBegin][j]);
                totalEle--;
            }
            rowBegin++;
            
            //down
            for(int i = rowBegin; i <= rowEnd && totalEle > 0; i++){
                res.add(matrix[i][colEnd]);
                totalEle--;
            }
            colEnd--;
            
            //right
            for(int j = colEnd; j >= colBegin && totalEle > 0; j--){
                res.add(matrix[rowEnd][j]);
                totalEle--;
            }
            rowEnd--;
            
            //up
            for(int i = rowEnd; i >= rowBegin && totalEle > 0; i--){
                res.add(matrix[i][colBegin]);
                totalEle--;
            }
            colBegin++;
            
        }
        
        return res;
        
    }
}