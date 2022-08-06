class Solution {
    public int subtractProductAndSum(int n) {
        int prd = 1;
        int sum = 0;
        
        while(n > 0){
            int ld = n%10;
            prd = prd * ld;
            sum = sum + ld;
            
            n = n/10;
        }
        
        return prd-sum;
    }
}