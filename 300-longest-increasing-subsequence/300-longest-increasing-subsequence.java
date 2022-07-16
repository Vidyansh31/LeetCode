class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ahead= new int[n+1];
        
        for(int i = n-1; i >= 0; i--){
            int[] curr = new int[n+1];
            for(int j = i-1; j >= -1; j--){
                //not take
                int l1 =  ahead[j+1];

                int l2 = 0;

                if(j == -1 || nums[i] > nums[j]){
                    l2 = 1 + ahead[i+1];
                }

                curr[j+1] = Math.max(l1,l2);
            }
            
            ahead= curr;
        }
        
        return ahead[0];
    }
    
   
}