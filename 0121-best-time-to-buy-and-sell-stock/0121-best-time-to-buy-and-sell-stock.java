class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i++){
            minSoFar = Math.min(prices[i],minSoFar);
            int profit = prices[i] - minSoFar;
            
            maxProfit = Math.max(profit,maxProfit);
        }
        
        return maxProfit;
        
    }
}