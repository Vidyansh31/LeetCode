class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        int iof2 = 1;
        int iof3 = 1;
        int iof5 = 1;

        for(int i = 2; i <= n; i++ ){
            int mof2 = dp[iof2]*2;
            int mof3 = dp[iof3]*3;
            int mof5 = dp[iof5]*5;

            dp[i] = Math.min(mof2, Math.min(mof3,mof5));

            if(dp[i] == mof2){
                iof2++;
            }
            
            if(dp[i] == mof3){
                iof3++;
            }
            
            if(dp[i] == mof5){
                iof5++;
            }
        }

        return dp[n];
    
    }
}