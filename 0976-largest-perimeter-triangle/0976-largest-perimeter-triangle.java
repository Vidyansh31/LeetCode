class Solution {
    public int largestPerimeter(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int k = 2;
        int max = 0;
        while(k < n){
            if(nums[i]+nums[j] > nums[k]){
                max = Math.max(max, nums[i]+nums[j]+nums[k]);
            }
            i++;
            j++;
            k++;
        }
        
        return max;
    }
}