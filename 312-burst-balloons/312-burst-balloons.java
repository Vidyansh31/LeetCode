class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g ; j < n; j++,i++){
                
                for(int lk = g + 1, rk = 1; lk >= 1; lk--, rk++){
                    int left = (lk == g + 1 ? 0 : dp[i][j-lk]);
                    int right = (rk == g+1 ? 0 : dp[i+rk][j]);
                    int factor = (i - 1 >= 0 ? nums[i-1] : 1) *
                                    nums[i + rk - 1] *
                                (j + 1 < n ? nums[j+1] : 1);
                    
                    dp[i][j] = Math.max(dp[i][j], left+right+factor);
                }
            }
        }
        
        
        return dp[0][n-1];
    }
}