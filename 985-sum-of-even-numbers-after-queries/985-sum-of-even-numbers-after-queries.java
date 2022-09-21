class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for(int num : nums){
            if(num%2 == 0){
                evenSum += num;
            }
        }
        
        int n = queries.length;
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++){
            int val = queries[i][0];
            int idx = queries[i][1];
            
            if(nums[idx] % 2 == 0){
                evenSum -= nums[idx];
            }
            
            nums[idx] += val;
            
            if(nums[idx]%2 == 0){
                evenSum += nums[idx];
            }
            
            ans[i] = evenSum;
        }
        
        return ans;
    }
}