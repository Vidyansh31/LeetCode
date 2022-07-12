class Solution {
    public boolean makesquare(int[] nums) {
        if(nums.length < 4) return false;
        
        int perimeter = 0;
        for(int num : nums){
            perimeter += num;
        }
        
        if(perimeter %4 != 0) return false;
        
        int side = perimeter/4;
        Arrays.sort(nums);
        reverse(nums);
        int[] sides = new int[] {side,side,side,side};
        
        return helper(nums, 0, sides);
    }
    
    private boolean helper(int[] nums, int st, int[] sides){
        if(st == nums.length){
            return true;
        }
        
        for(int i = 0;i < 4; i++){
            if(nums[st] > sides[i]) continue;
            sides[i] -= nums[st];
            if(helper(nums,st+1,sides)){
                return true;
            }
            sides[i] += nums[st];
        }
        
        return false;
    }
    
    private void reverse(int[] nums){
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}