class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n+1][amount+1];
        int ans =  helper(coins,amount,n-1,dp);
        return ans == (int)1e9 ? -1 : ans;
    }
    
    public int helper(int[] arr, int tar, int idx, Integer[][] dp){
        if(idx == 0){
            if(tar%arr[0] == 0){
                return tar/arr[0];
            }
            return (int)1e9;
        }
        
        if(dp[idx][tar] != null){
            return dp[idx][tar];
        }
        
        int notTake = helper(arr,tar,idx-1,dp);
        
        int take = (int)1e9;
        
        if(tar >= arr[idx]) take = 1 + helper(arr,tar-arr[idx],idx,dp);
        
        return dp[idx][tar] = Math.min(take,notTake);
    }
}