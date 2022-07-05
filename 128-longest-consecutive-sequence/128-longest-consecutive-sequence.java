class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        
        int maxl = 0;
        
        for(int i = 0; i < nums.length; i++){
           if(!set.contains(nums[i] - 1)){
                int currNum = nums[i];
               int len = 1;
            while(set.contains(currNum+1)){
                len++;
                currNum = currNum + 1;
            }
            
            maxl = Math.max(maxl,len);
            
           }
        }
        
        return maxl;
    }
}