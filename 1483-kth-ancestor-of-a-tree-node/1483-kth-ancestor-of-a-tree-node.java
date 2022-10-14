class TreeAncestor {
    
    
    
    int[][] dp;
    int ht;
    public TreeAncestor(int n, int[] parent) {
        
        dp = new int[16][n];
        
        for(int bit = 0; bit < dp.length; bit++){
            for(int j = 0; j < dp[0].length; j++){
                if(bit == 0){
                    dp[bit][j] = parent[j];
                }
                else{
                    int s1 = dp[bit-1][j];
                    dp[bit][j] = s1 == -1 ? -1 : dp[bit-1][s1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
      
        int bit = 0;
        int res = node;
        while((1 << bit) <= k){
            boolean on = ((1 << bit) & k) == 0 ? false : true;
            
            if(on){
                res = dp[bit][res];
                if(res == -1){
                    return -1;
                }
            }
            bit++;
        }
        
        return res;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */