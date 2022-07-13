class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int idx1 = text1.length()-1;
        int idx2 = text2.length()-1;
        Integer[][] dp = new Integer[idx1+1][idx2+1];
        return helper(text1,idx1,text2,idx2,dp);
    }
    
    private int helper(String s1, int idx1, String s2 , int idx2, Integer[][] dp){
    
        if(idx1 < 0 || idx2 < 0){
            return 0;
        }
        
        
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
       
        //when last char matches
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] =  1 + helper(s1,idx1-1, s2, idx2-1,dp);
        }
        
        return dp[idx1][idx2] =  Math.max(helper(s1,idx1-1,s2,idx2,dp),helper(s1, idx1, s2, idx2-1,dp));
     
    }
}