class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        
        for(int i = arr.length-1; i >= 0; i--){  
            int len = 0, maxi = 0, MaxAns = 0;
            for(int j = i; j < Math.min(arr.length,i+k); j++){
                len++;
                maxi = Math.max(maxi,arr[j]);
                int ans = (len*maxi) + dp[j+1];
                MaxAns = Math.max(MaxAns, ans);
            }

             dp[i] =  MaxAns;
        }
        
       return dp[0];
    }
    
    private int helper(int[] arr, int idx, int k, int[] dp){
        
        if(idx == arr.length){
            return 0;
        }
        
        if(dp[idx] != 0){
            return dp[idx];
        }
        
        int len = 0, maxi = 0, MaxAns = 0;
        for(int j = idx; j < Math.min(arr.length,idx+k); j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            int ans = (len*maxi) + helper(arr,j+1,k,dp);
            MaxAns = Math.max(MaxAns, ans);
        }
        
        return dp[idx] =  MaxAns;
    }
}