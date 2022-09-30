class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1){
            return 1;
        }
        
        long[] dp = new long[n+1];
        dp[1] = 1;
        
        int[] idces = new int[primes.length];
        Arrays.fill(idces,1);
        
        for(int i = 2; i <= n; i++){
            long ans = Long.MAX_VALUE;
            
            for(int j = 0; j < primes.length; j++){
                int prime = primes[j];
                int idx = idces[j];
                
                ans = Math.min(ans, prime*dp[idx]);
            }
            
            dp[i] = ans;
            
            for(int j = 0; j < primes.length; j++){
                int prime = primes[j];
                int idx = idces[j];
                
                if(dp[i] == prime*dp[idx]){
                    idces[j] = idx+1;
                }
            }
            
        }
        
        
        return (int)dp[n];
    }
}