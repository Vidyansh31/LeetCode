class Solution {
    public boolean canJump(int[] arr) {
         int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] == -1){
                    return false;
                }
                else if(arr[j]+j >= i){
                    dp[i] = dp[j]+1;
                    break;
                }
            }
        }
        
        if(dp[arr.length -1] != -1){
            return true;
        }
        
        return false;
    }
}