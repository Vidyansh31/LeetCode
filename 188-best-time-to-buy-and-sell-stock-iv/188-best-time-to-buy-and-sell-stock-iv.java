class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] prev = new int[2*k+1];
        
        for(int i = n-1; i >= 0; i--){
            int[] curr = new int[2*k+1];
            for(int j = 0; j < 2*k; j++){
                int profit = 0;
        
                if(j%2 == 0){
                    profit = Math.max(-prices[i]+prev[j+1],prev[j]);
                }
                else{
                    profit = Math.max(prices[i]+prev[j+1],prev[j]);
                }

                curr[j] = profit;
            }
            prev = curr;
        }
        
        return prev[0];
    }
    
    
}