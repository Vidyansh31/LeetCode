class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        int[] prev = new int[m+1];
        for(int i = n, j = 0; j <= m; j++){
            prev[j] = matrix[i][j];
        }
        
        
        for(int i = n-1; i >= 0; i--){
            int[] temp = new int[m+1];
            for(int j = m; j >= 0; j--){
                 if(j == m){
                    temp[j] = matrix[i][j] + Math.min(prev[j],prev[j-1]);
                }
                else if(j == 0){
                    temp[j] = matrix[i][j] + Math.min(prev[j],prev[j+1]);
                }
                else{
                    temp[j] = matrix[i][j] + Math.min(prev[j],Math.min(prev[j+1],prev[j-1]));
                }
                
            }
            
            
            
            prev = temp;
           
            
        }
        
        
        
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j <= m; j++){
            ans = Math.min(prev[j],ans);
        }
        
        return ans;
    }
    
    
}