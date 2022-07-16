class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> {
            return a.length() - b.length();
        });
        
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int ans = 1;
        
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                 if( Compare(words[i],words[prev]) && 1 + dp[prev] > dp[i] ){
                    dp[i] = 1 + dp[prev];
                }
                
            }
            if(dp[i] > ans){
                ans = dp[i];
            }
        }
        
        return ans;
    }
    
    private boolean Compare(String s, String p){
        if(s.length() != p.length()+1) return false;
        int i = 0;
        int j = 0;
        while( i < s.length()){
            if(j < p.length() && s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        
        if(i == s.length() && j == p.length()) return true;
        
        return false;
    }
        
        
        
    
    
}