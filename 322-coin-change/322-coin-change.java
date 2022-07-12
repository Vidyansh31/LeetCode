class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp  = new int[amount+1];
        
        //write base case
        for(int i = 0; i < amount+1; i++){
            if(i%coins[0] == 0) dp[i] = i/coins[0];
            else{
                dp[i] = (int)1e9;
            }
        }
        
        for(int i = 1; i < n; i++){
            int[] curr  = new int[amount+1];
            for(int j = 0; j <= amount; j++){
                int notTake = dp[j];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j) take = 1 + curr[j-coins[i]];

                curr[j] = Math.min(take,notTake);
            }
            dp = curr;   
        }
        
        return dp[amount] != (int)1e9 ? dp[amount] : -1;
    }
    
   
}