class Solution {
    public int findDuplicate(int[] nums) {
        return store(nums,0);
    }
    
    public int store(int[] nums, int curr){
        if(nums[curr] == curr){
            return curr;
        }
        
        int nxt = nums[curr];
        nums[curr] = curr;
        
        return store(nums,nxt);
    }
}