class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        
        for(int i = n; i >= 0; i--){
            for(int j = m; j >= 0; j--){
                if(i == n && j == m){
                    dp[i][j] = true;
                }
                else if(j == m){
                    dp[i][j] = false;
                }
                else if(i == n){
                    if(j+1 < p.length() && p.charAt(j+1) == '*'){
                        dp[i][j] = dp[i][j+2];
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                else{
                     if(j+1 < p.length() && p.charAt(j+1) == '*'){
                        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                            dp[i][j] = dp[i+1][j] || dp[i][j+2];
                        }
                        else{
                            dp[i][j] = dp[i][j+2];
                        }
                    }
                    else {
                        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                            dp[i][j] = dp[i+1][j+1];
                        }
                        else{
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}