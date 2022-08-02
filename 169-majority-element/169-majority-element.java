class Solution {
    public int majorityElement(int[] nums) {
        int nums1 = 0;
        int c1 = 0;
        
        int i = 0;
        
        while( i < nums.length){
            if(nums1 == nums[i]){
                c1++;
            }
            else if(c1 == 0){
                nums1 = nums[i];
                c1++;
            }
            else{
                c1--;
            }
            i++;
        }
        
        int count = 0;
        i = 0;
        while(i < nums.length){
            if(nums1 == nums[i]){
                count++;
            }
            i++;
        }
        
        return count >= nums.length/2 ? nums1 : -1;
        
    }
}