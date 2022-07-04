class Solution {
    public int[] countBits(int n) {
        
        int[] ans = new int[n+1];
        if(n == 0){
            ans[0] = 0;
            return ans;
        }
        if(n == 1){
            ans[0] = 0;
            ans[1] = 1;
            return ans;
        }
        ans[0] = 0;
        ans[1] = 1;
        for(int i = 2; i < ans.length ; i++){
            if(i <= 3){
                ans[i] = ans[i-1]+ans[i-2];
            }
            
            ans[i] = ans[i/2]+ans[i%2];
        }
        
        return ans;
    }
}