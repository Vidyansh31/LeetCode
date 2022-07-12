class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];
        int ans = helper(coins,n-1,amount,dp) ;
        return ans != (int)1e9 ? ans : -1;
    }
    
     private static int helper(int[] arr, int idx, int x,Integer[][] dp) {
        
        if(idx == 0){
            if(x%arr[idx] == 0){
                return x/arr[idx];
            }
            else{
                return (int)1e9;
            }
        }
         
         if(dp[idx][x] != null){
             return dp[idx][x];
         }
        
        int notTake = helper(arr,idx-1,x,dp);
        int take = Integer.MAX_VALUE;
        if(arr[idx] <= x) take = 1 + helper(arr,idx,x-arr[idx],dp);
        
        return dp[idx][x] = Math.min(take,notTake);
    }
}