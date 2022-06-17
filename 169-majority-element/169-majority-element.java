class Solution {
    public int majorityElement(int[] nums) {
        
        // Bayer Moore Voting algorithm
        int ans = -1;
        int count = 0;
        
        for(int el : nums){
            if(el == ans) 
                count++;
            else if(count == 0){
                ans = el;
                count = 1;
            }
            else{
                count--;
            }
        }
        
            count = 0;
        for (int index = 0; index < nums.length; index++) {
          if (nums[index] == ans)
            count++;
        }
        if (count > (nums.length / 2))
          return ans;
        return -1;
    }
}