class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int i = 0;
        int j = 0;
        long sum = 0;
        
        for(; j < nums.length; j++){
            sum += nums[j];
            
            while(k + sum < (long)nums[j]*(j-i+1)){
                sum -= nums[i++];
            }
            
            res = Math.max(res,(j-i+1));
            
        }
        
        return res;
    }
}