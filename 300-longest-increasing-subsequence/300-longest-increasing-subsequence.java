class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int i = n-1; i >= 0; i--){
            for(int j = i-1; j >= -1; j--){
                //not take
                int l1 =  dp[i+1][j+1];

                int l2 = 0;

                if(j == -1 || nums[i] > nums[j]){
                    l2 = 1 + dp[i+1][i+1];
                }

                dp[i][j+1] = Math.max(l1,l2);
            }
        }
        
        return dp[0][0];
    }
    
   
}