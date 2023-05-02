class Solution {
    public int arraySign(int[] nums) {
        int pos = 0;
        int neg = 0;
        
        for(int num : nums){
            if(num > 0){
                pos++;
            }
            else if(num < 0){
                neg++;
            }
            else{
                return 0;
            }
        }
        
        return neg%2 == 0 ? 1 : -1;
    }
}