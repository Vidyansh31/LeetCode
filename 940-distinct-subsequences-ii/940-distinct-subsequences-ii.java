class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 2;
        
        int[] lo = new int[26];
        lo[s.charAt(0) - 'a'] = 1;
    
        for(int i = 2; i <= s.length(); i++){
            int  ch = s.charAt(i-1) - 'a';
            if(lo[ch] != 0){
                dp[i] = 2*dp[i-1] - dp[lo[ch] -1];
            }
            else{
                dp[i] = 2 * dp[i-1];
            }
            
            lo[ch] = i;
            dp[i] = dp[i] < 0 ? (dp[i]+mod)%mod : dp[i]%mod; 
        }
        
        return dp[dp.length-1]-1;
    }
}