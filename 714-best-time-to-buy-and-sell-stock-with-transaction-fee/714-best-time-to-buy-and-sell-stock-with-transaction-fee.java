class Solution {
    public int maxProfit(int[] prices, int fee) {
       int obp = -prices[0];
        int osp = 0;
        
        for(int i = 1; i < prices.length; i++){
            int nbp = Math.max(osp-prices[i] , obp);
            int nsp = Math.max(obp+prices[i]-fee, osp);
            
            obp = nbp;
            osp = nsp;
        }
        
        return osp;
    }
}