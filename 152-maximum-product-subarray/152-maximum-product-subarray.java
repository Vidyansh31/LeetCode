class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        
        int prd =1;
        
        for(int i = 0; i < nums.length; i++){
            prd = prd*nums[i];
            res = Math.max(prd,res);
            
            if(prd == 0){
                prd = 1;
            }
        }
        
        prd = 1;
         for(int i = nums.length-1; i >= 0; i--){
            prd = prd*nums[i];
            res = Math.max(prd,res);
            
            if(prd == 0){
                prd = 1;
            }
        }
        
        return res;
    }
}