class Solution {
    public int[] countBits(int n) {
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            if(i%2 == 0){
                dp[i] = dp[i/2];
            }
            else{
                dp[i] = 1 + dp[i-1];
            }
        }
        return dp;
    }
}