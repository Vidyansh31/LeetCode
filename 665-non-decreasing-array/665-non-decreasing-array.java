class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        
        int change = 0;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < prev){
                if(change == 1){
                    return false;
                 }
                change++;
                
                if( i >= 2 && nums[i-2] > nums[i]) continue;
            } 
            
            prev = nums[i];
            
            
        }
     
        
        return true;
    }
}