class Solution {
    public void nextPermutation(int[] nums) {
        int dipPoint = -1;
        
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i-1] < nums[i]){
                dipPoint = i-1;
                break;
            }
        }
        
        
        
        if(dipPoint != -1){
            for(int i = nums.length-1; i > dipPoint; i--){
                if(nums[i] > nums[dipPoint]){
                    int temp = nums[i];
                    nums[i] = nums[dipPoint];
                    nums[dipPoint] = temp;

                    break;
                }
            }
        }
        
        reverse(nums, dipPoint + 1, nums.length-1);
        
        
    }
    
    void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            
            lo++;
            hi--;
        }
    }
}