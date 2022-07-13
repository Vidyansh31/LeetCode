class Solution {
    public int longestPalindromeSubseq(String s) {
         StringBuilder str = new StringBuilder(s);
         str.reverse();
        int n = s.length();
        int m = str.length();
        
        int[] prev = new int[str.length()+1];
        
        //base cases
        for(int i = 0; i <=m; i++){
            prev[i] = 0;
        }
        
        for(int i = 1; i <= n; i++){
            int[] curr = new int[str.length()+1];
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == str.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = Math.max(curr[j-1],prev[j]);
                }
            }
            prev = curr;
        }
        
       
        
        return prev[n];
    }
    
   
}