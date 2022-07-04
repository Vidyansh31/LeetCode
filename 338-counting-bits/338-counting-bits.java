class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for(int i = 0; i < ans.length ; i++){
            ans[i] = Integer.bitCount(i);
        }
        
        return ans;
    }
}