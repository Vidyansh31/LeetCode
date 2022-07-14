class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        
        Boolean[][] dp = new Boolean[n][m];
        
        return helper(s,p,n-1,m-1,dp);
    }
    
    private boolean helper(String s, String p, int idx1, int idx2, Boolean[][] dp){
        
        if(idx1 < 0 && idx2 < 0){
            return true;
        }
        
        if(idx1 >= 0 && idx2 < 0){
            return false;
        }
        
        if(idx1 < 0 && idx2 >= 0){
            for(int i = 0; i <=idx2 ; i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        
        
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        
        if(s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?'){
            return dp[idx1][idx2] = helper(s,p,idx1-1,idx2-1,dp);
        }
        
        if(p.charAt(idx2) == '*'){
            return dp[idx1][idx2] = helper(s,p,idx1-1,idx2,dp) || helper(s,p,idx1,idx2-1,dp);
        }
        
        return false;
    }
}