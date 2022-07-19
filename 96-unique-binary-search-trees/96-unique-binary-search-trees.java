class Solution {
    public int numTrees(int n) {
        // n = 1 2 3 4 5 ...
        //sol= 1 2 5 14 42 ... this series in catalan series
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        return helper(dp,n);
    }
    
    private int helper(int[] dp, int n){
        if(n==1) return dp[n] = 1;
        if(n==2) return dp[n] = 2;
        
        if(dp[n] != 0){
            return dp[n];
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans += helper(dp,i-1)*helper(dp,n-i);
        }
        
        return dp[n] = ans;
    }
}