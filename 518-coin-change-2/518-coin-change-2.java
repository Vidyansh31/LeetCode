class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];
        return helper(coins,n-1,amount,dp);
    }
    
    private int helper(int[] arr, int idx, int x,Integer[][] dp){
        
        if(idx == 0){
            if(x % arr[0] == 0){
                return 1;
            }
            
            return 0;
        }
        
        if(dp[idx][x] != null){
            return dp[idx][x];
        }
        
        int take = 0;
        if(arr[idx] <= x) take = helper(arr,idx,x-arr[idx],dp);
        int notTake = helper(arr,idx-1,x,dp);
    
        return dp[idx][x] = notTake + take;
    }
}