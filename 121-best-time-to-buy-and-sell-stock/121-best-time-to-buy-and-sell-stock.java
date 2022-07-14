class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - minSoFar;
            maxProfit = Math.max(profit,maxProfit);
            minSoFar =  Math.min(minSoFar,prices[i]);
        }
        
        return maxProfit;
    }
}