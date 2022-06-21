class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){
                int currNum = nums[i];
                int length = 1;
                
                while(set.contains(currNum+1)){
                    currNum++;
                    length++;
                }
                
                count = Math.max(length,count);
            }
        }
        
        return count;
    }
}