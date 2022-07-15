class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        
        for(int i = n-1; i>= 0; i--){
            for(int j = 0; j < 2; j++){
                int p1= 0;
                if(j == 1){
                    //buying possibilites
                    p1 = Math.max(-prices[i]+dp[i+1][j-1],dp[i+1][j]);
                }
                else{
                    //not buying possibilites
                    p1 = Math.max(prices[i]+dp[i+1][j+1],dp[i+1][j]);
                }

                dp[i][j] = p1;
            }
        }
        
        
        return  dp[0][1];
                                  
    }
                        
}