class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 2;
        
        int[] prev = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                prev[i] = map.get(ch);
            }
            else{
                prev[i] = -1;
            }
            
            map.put(ch,i);
        }
    
        for(int i = 2; i <= s.length(); i++){
            char ch = s.charAt(i-1);
            if(prev[i-1] == -1){
                dp[i] = 2*dp[i-1];
            }
            else{
                dp[i] = 2*dp[i-1] - dp[prev[i-1]];
            }
            
            dp[i] = dp[i] < 0 ? (dp[i]+mod)%mod : dp[i]%mod; 
        }
        
        return dp[dp.length-1]-1;
    }
}