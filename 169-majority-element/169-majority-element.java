class Solution {
    public int majorityElement(int[] nums) {
        int el = 0;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(el == nums[i]){
                count++;
            }
            else if(count == 0){
                el = nums[i];
                count = 1;
            }
            else{
                count--;
            }
        }
        
        count = 0;
        
        for(int num : nums){
            if(num == el){
                count++;
            }
        }
        
        if(count > nums.length/2){
            return el;
        }
        
        return 0;
    }
}