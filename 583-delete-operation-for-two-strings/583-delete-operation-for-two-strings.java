class Solution {
    public int minDistance(String word1, String word2) {
       
        
        int n = word1.length();
        int m = word2.length();
        
       
        Integer[][] dp = new Integer[n][m];
        int lcs = helper(word1,word2,n-1,m-1,dp);
        
        return n + m - 2*lcs;
    }
    
    private int helper(String s1, String s2, int idx1, int idx2, Integer[][] dp){
        
        if(idx1 < 0 || idx2 < 0){
            return 0;
        }
        
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = 1 + helper(s1,s2,idx1-1,idx2-1,dp);
        }
        
        return dp[idx1][idx2] = Math.max(helper(s1,s2,idx1-1,idx2,dp), helper(s1,s2,idx1,idx2-1,dp));
    }
}