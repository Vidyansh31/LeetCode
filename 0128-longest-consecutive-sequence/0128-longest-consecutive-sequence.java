class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int maxLen = 0;
        
        for(int i = 0; i < nums.length; i++){
            int count = 1;
            
            int num1 = nums[i]-1;
            while(set.contains(num1)){
                count++;
                
                set.remove(num1);
                num1--;
            }
            
            int num2 = nums[i]+1;
            while(set.contains(num2)){
                count++;
                set.remove(num2);
                num2++;
            }
            
            maxLen = Math.max(maxLen, count);
        }
        
        return maxLen;
    }
}