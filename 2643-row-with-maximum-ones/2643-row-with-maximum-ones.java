class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        int OneCount = 0;
        int row = -1;
        int maxOne = 0;
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    OneCount++;
                }
            }
            
            if(maxOne < OneCount){
                row = i;
                maxOne = OneCount;
                
            }
            
            OneCount = 0;
            
        
        }
        
        if(row != -1){
            ans[0] = row;
        ans[1] = maxOne;
        }
        
        return ans;
    }
}