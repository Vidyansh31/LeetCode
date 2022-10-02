class Solution {
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(n,k,target,dp);
    }
    
    public int solve(int dices, int faces, int target, int[][] dp){
        if(target < 0){
            return 0;
        }
        if(dices == 0 && target != 0){
            return 0;
        }
        
        if(dices != 0 && target == 0){
            return 0;
        }
        
        if(dices == 0 && target == 0){
            return 1;
        }
        
        if(dp[dices][target] != -1){
            return dp[dices][target];
        }
        
        int ans = 0;
        for(int i = 1; i <= faces; i++){
            ans = (ans + solve(dices-1,faces,target-i,dp))%mod;
        }
        
        return dp[dices][target] = ans%mod;
    }
}