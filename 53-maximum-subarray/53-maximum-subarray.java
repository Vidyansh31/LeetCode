class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    
    public int helper(int nums[],int i,int j){

        if(i==j){
            return nums[i];
        }
                          
        int mid  =  (i+j)/2;
        int sum = 0,leftMaxSUM = Integer.MIN_VALUE;
        
        for(int l =  mid;l>=i;l--){
            sum+=nums[l];
            if(sum>leftMaxSUM){
                leftMaxSUM =  sum;
            }                                    
        }
        
     int rightMaxSUM = Integer.MIN_VALUE;
        sum = 0;    // reset sum to 0
        for (int l = mid + 1; l <=j; l++)
        {
            sum += nums[l];
            if (sum > rightMaxSUM ) {
                rightMaxSUM = sum;
            }
        }
        
       int maxLeftRight = Math.max(helper(nums, i, mid),
                                    helper(nums, mid + 1, j ));
        return Math.max(maxLeftRight, leftMaxSUM + rightMaxSUM );
        
        
    
    }
}