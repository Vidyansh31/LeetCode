class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 1;
        tails[0] = nums[0];
        
        for(int i = 1; i < n; i++){
            if(nums[i] > tails[len-1]){
                len++;
                tails[len-1] = nums[i];
            }
            else{
                int idx = Arrays.binarySearch(tails,0,len-1,nums[i]);
                
                if(idx < 0){
                    idx = -idx;
                    idx = idx -1 ;
                }
                
                tails[idx] = nums[i];
            }
        }
        
        return len;
    }
}