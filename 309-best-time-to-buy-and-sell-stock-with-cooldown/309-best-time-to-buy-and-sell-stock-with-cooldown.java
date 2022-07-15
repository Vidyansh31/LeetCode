class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] prev2 = {0,0};
        int[] prev1 = {0,0}; 
        
        
        
        for(int i = n-1; i >= 0; i--){
            int[] curr = new int[2];
            
            curr[1] = Math.max(-prices[i]+prev1[0],prev1[1]);
                
            curr[0] = Math.max(prices[i]+prev2[1],prev1[0]);
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1[1];
    }
    
    
}