class Solution {
    public boolean check(int[] nums) {
        int dip = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            if(nums[i] > nums[(i+1)%n]){
                dip++;
            }
        }
       
        return dip <= 1 ;
    }
}