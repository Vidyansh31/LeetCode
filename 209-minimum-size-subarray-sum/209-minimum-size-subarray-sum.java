class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        
        int sum = 0;
        int mini = Integer.MAX_VALUE ;
        while(j < nums.length){
            sum += nums[j];
            
            if(sum < target){
                j++;
            }
            else{
                 while(sum >= target){
                    sum -= nums[i];
                    mini = Math.min(mini,j-i+1);
                    i++;
                }
                j++;   
            }
        }
        
        return mini == Integer.MAX_VALUE ? 0 : mini;
    }
}