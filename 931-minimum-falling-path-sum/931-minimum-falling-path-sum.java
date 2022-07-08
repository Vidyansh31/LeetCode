class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int minFall = Integer.MAX_VALUE;
        int i = 0;
        for(int j = 0; j < matrix[0].length; j++){
            int ans = helper(matrix,i,j,dp);
            minFall = Math.min(ans,minFall);
        }
        
        return minFall;
    }
    
    private int helper(int[][] arr, int i, int j,int[][] dp){
        if(j >= arr[0].length || j < 0 ){
            return Integer.MAX_VALUE;
        }
        
         if(i == arr.length-1){
            return arr[i][j];
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int leftDia = helper(arr,i+1,j-1,dp);
        int down = helper(arr,i+1,j,dp);
        int rightDia = helper(arr, i+1, j+1,dp);
        
        
        return dp[i][j] = arr[i][j] + Math.min(down,Math.min(leftDia,rightDia));
    }
}