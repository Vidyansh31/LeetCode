class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int f, int s) {
        int max1 = getMax(nums,f,s);
        int max2 = getMax(nums,s,f);
        return Math.max(max1,max2);
    }
    
    public int getMax(int[] nums, int f, int s){
        int[] left = new int[nums.length];
        
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if(i == f-1){
                left[i] = sum;
            }
            else if(i >= f){
                sum -= nums[i-f];
                left[i] = Math.max(sum,left[i-1]);
            }
        }
        
        int[] right = new int[nums.length];
        sum = 0;
        
        for(int i = nums.length-1; i >= 0; i--){
            sum += nums[i];
            
            if(i == nums.length-s){
                right[i] = sum;
            }
            else if(i < nums.length-s){
                sum -= nums[i+s];
                right[i] = Math.max(sum,right[i+1]);
            }
        }
        
        int maxi = 0;
        for(int i = f-1; i < nums.length-s;i++){
            maxi = Math.max(maxi,left[i]+right[i+1]);
        }
        
        return maxi;
    }
}