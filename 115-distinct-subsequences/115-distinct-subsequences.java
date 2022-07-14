class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        Integer[][] dp = new Integer[n][m];
        
        return helper(s,t,n-1,m-1,dp);
    }
    
    private int helper(String s1, String s2, int idx1, int idx2,Integer[][] dp){
        if(idx2 < 0){
            return 1;
        }
        
        if(idx1 < 0){
            return 0;
        }
        
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = helper(s1,s2,idx1-1,idx2-1,dp) + helper(s1,s2,idx1-1,idx2,dp);
        }
        
        return dp[idx1][idx2] = helper(s1,s2,idx1-1,idx2,dp);
    }
}