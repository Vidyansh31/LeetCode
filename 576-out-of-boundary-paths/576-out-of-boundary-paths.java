class Solution {
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int i, int j) {
        Integer[][][] dp = new Integer[m][n][maxMove+1];
        return helper(m,n,maxMove,i,j,dp);
    }
    
    private int helper(int m, int n, int maxMove, int i, int j,Integer[][][] dp){
        if(i < 0 || j < 0 || i >= m || j >= n){
            return 1;
        }
        
        if(maxMove == 0){
            return 0;
        }
        
        if(dp[i][j][maxMove] != null){
            return dp[i][j][maxMove];
        }
        
        int top = helper(m,n,maxMove-1,i-1,j,dp);
        int left = helper(m,n,maxMove-1,i,j-1,dp);
        int right = helper(m,n,maxMove-1,i,j+1,dp);
        int down = helper(m,n,maxMove-1,i+1,j,dp);
        
        
        return dp[i][j][maxMove] = ((top+left)%mod+(right+down)%mod)%mod;
    }
}