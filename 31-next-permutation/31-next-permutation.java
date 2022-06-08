class Solution {
    public void nextPermutation(int[] nums) {
        int point = -1;
        
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                point = i;
                break;
            }
        }
        if(point != -1){
            int j;
            for( j = nums.length-1; j > point; j--){
                if(nums[j] > nums[point]){
                    break;
                }
            }

            swap(nums,point,j);
        }
        
        reverse(nums,point+1,nums.length-1);
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[]nums, int st, int end){
        while(st <= end){
            swap(nums,st,end);
            st++;
            end--;
        }
    }
}