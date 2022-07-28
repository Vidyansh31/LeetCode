class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroes = 0;
        int i = 0;
        int j = 0;
        
        int maxlen = 0;
        
        while( j < nums.length){
            if(nums[j] == 0){
                zeroes++;
            } 
            
            if(zeroes <= k){
                j++;
            }
            else if(zeroes > k){
                
                
                if(nums[i] == 0){
                    zeroes--;
                }
                
                i++;
                j++;
            }
        }
        
        return j-i;
    }
}