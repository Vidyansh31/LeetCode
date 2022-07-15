class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] prev = new int[2];
        
        for(int i = n-1; i>= 0; i--){
            int[] curr = new int[2];
            for(int j = 0; j < 2; j++){
                int p1= 0;
                if(j == 1){
                    //buying possibilites
                    p1 = Math.max(-prices[i]+prev[j-1],prev[j]);
                }
                else{
                    //not buying possibilites
                    p1 = Math.max(prices[i]+prev[j+1],prev[j]);
                }

                curr[j] = p1;
            }
            
            prev = curr;
        }
        
        
        return  prev[1];
                                  
    }
                        
}