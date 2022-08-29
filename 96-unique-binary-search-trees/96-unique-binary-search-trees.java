class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        return helper(n,dp);
    }
    
    public int helper(int n , int[] dp){
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        int total = 0;
        for(int i = 1; i <= n; i++){
            int left = helper(i-1,dp);
            int right = helper(n-i,dp);
            
            total += left*right;
        }
        
        return dp[n] = total;
    }
}