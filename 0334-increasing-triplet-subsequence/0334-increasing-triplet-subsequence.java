class Solution {
    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        
        for(int num : nums){
            if(num <= num1){
                num1 = num;
            }
            else if(num <= num2){
                num2 = num;
            }
            else{
                return true;
            }
        }
        
        return false;
    }
}