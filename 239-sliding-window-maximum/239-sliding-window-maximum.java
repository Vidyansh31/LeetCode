class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n]; 
        
        leftMax[0] = nums[0];
        rightMax[n-1] = nums[n-1];
        
        for(int i = 1; i < n; i++){
            leftMax[i] = i%k == 0 ? nums[i] : Math.max(leftMax[i-1],nums[i]);
            
            int j = n-i-1;
            rightMax[j] = j%k == 0 ? nums[j] : Math.max(rightMax[j+1],nums[j]);
        }
        
        
        for(int i = 0, j = 0; i+k <= n; i++){
            ans[j++] = Math.max(rightMax[i],leftMax[i+k-1]);
        }
        
        return ans;
        
    }
}