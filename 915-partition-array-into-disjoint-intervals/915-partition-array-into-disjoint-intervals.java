class Solution {
    public int partitionDisjoint(int[] nums) {
        int mtp = nums[0];
        int mts = nums[0];
        int ans = 1;
        for(int i = 1; i < nums.length; i++){
            mts = Math.max(mts, nums[i]);
            
            if(mtp > nums[i]){
                ans = i+1;
                mtp = mts;
            }
        }
        
        return ans;
    }
}