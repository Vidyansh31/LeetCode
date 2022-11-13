class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[100000];
        int[] neg = new int[100000];
        int p = 0;
        int n = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                pos[p++] = nums[i];
            }
            else{
                neg[n++] = nums[i];
            }
        }
        
        int[] ans = new int[nums.length];
        p = 0; 
        n = 0;
        
        for(int i = 0; i < ans.length; i++){
            if(i%2 == 0){
                ans[i] = pos[p++];
            }
            else{
                ans[i] = neg[n++];
            }
        }
        
        return ans;
       
    }
}