class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = nums.length-1;
        int idx = nums.length-1;
        
        while(l <= r ){
            int left = Math.abs(nums[l]*nums[l]);
            int right = Math.abs(nums[r]*nums[r]);
            
            if(left < right){
                result[idx] = right;
                r--;
            }
            else{
                result[idx] = left;
                l++;
            }
            
            idx--;
        }
        
        return result;
    }
}