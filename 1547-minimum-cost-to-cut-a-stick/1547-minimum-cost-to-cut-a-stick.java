class Solution {
    public int minCost(int n, int[] cuts) {
        
        int[] cut = new int[cuts.length+2];
        cut[0] = 0;
        for(int i = 1; i <= cuts.length; i++){
            cut[i] = cuts[i-1];
        }
        cut[cut.length-1] = n;
         Arrays.sort(cut);
        
        Integer[][] dp = new Integer[cut.length][cut.length];
       
       
        
        return helper( 1, cuts.length, cut,dp);
    }
    
    private int helper(int i, int j , int[] cut, Integer[][] dp){
        if( i > j){
            return 0;
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        int mini = Integer.MAX_VALUE;
        
        for(int k = i; k <= j; k++){
            int step = cut[j+1] - cut[i-1] + helper(i, k-1, cut,dp)+helper(k+1,j,cut,dp);
            mini = Math.min(step,mini);
        }
        
        return dp[i][j] = mini;
    }
}