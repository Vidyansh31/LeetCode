class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        
        int minEle = nums[0];
        
        int count = 0;
        
        for(int i = 1; i < nums.length; i++){
            count += nums[i] - minEle;
        }
        
        return count;
       
    }
}