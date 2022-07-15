class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //total 4 transaction - B S B S
        int[] ahead = new int[5];
        
        for(int i = n-1; i >= 0; i--){
            int[] curr = new int[5];
            for(int j = 0; j <= 3; j++){
                int profit = 0;
                if(j%2 == 0){
                    profit = Math.max(-prices[i]+ahead[j+1], ahead[j]);
                }
                else{
                     profit = Math.max(prices[i]+ahead[j+1], ahead[j]);
                }

                 curr[j] =  profit;
            }
            
            ahead = curr;
        }
        
        
        return ahead[0];
    }
    
    
}