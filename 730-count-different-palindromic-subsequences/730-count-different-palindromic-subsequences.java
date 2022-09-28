class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        
        int[][] dp = new int[n][n];
        
        HashMap<Character,Integer> map = new HashMap<>(); 
        int[] prev = new int[n];
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                prev[i] = map.get(ch);
            }
            else{
                prev[i] = -1;
            }
            
            map.put(ch,i);
        }
        
        map.clear();
        
        int[] next = new int[n];
        
        for(int i = n-1; i >= 0; i--){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                next[i] = map.get(ch);
            }
            else{
                next[i] = -1;
            }
            
            map.put(ch,i);
        }
        
        int mod = 1000000007;
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; j < n; i++, j++){
                if(g == 0){
                    dp[i][j] = 1;
                }
                else if(g == 1){
                    dp[i][j] = 2;
                }
                else{
                    
                    if(s.charAt(i) != s.charAt(j)){
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                    }
                    else{
                        int ne = next[i];
                        int p = prev[j];
                        
                        if(ne > p){
                            dp[i][j] = (2 * dp[i+1][j-1]) + 2;
                        }
                        else if(ne == p){
                            dp[i][j] = (2 * dp[i+1][j-1]) + 1;
                        }
                        else{
                            dp[i][j] = (2*dp[i+1][j-1]) - dp[ne+1][p-1];
                        }
                    }
                }
                
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        
        return dp[0][n-1];
    }
}