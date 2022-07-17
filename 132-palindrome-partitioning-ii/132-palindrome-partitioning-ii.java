class Solution {
    public int minCut(String s) {
        Integer[] dp = new Integer[s.length()+1];
        return helper(0,s,dp) - 1;
    }
    
    private int helper(int i, String s,Integer[] dp){
        
        if(i == s.length()){
            return 0;
        }
        
        
        if(dp[i] != null){
            return dp[i];
        }
        
        int minCost = Integer.MAX_VALUE;
        
        for(int j = i; j < s.length(); j++){    
            if(isPalindrome(s,i,j)){
                int cost = 1 + helper(j+1,s,dp);
                minCost = Math.min(cost,minCost);
            }
        }
        
        
        return dp[i]=  minCost;
    }
    
    private boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}