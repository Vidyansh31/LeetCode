class Solution {
    public int reversePairs(int[] nums) {
        
        int[] temp = new int[nums.length];
        return mergeSort(nums,temp,0,nums.length-1);
    }
    
    public int mergeSort(int[] nums, int[] temp, int left, int right){
        int rPair = 0;
        if(left < right){
            int mid = (left+right)/2;
            
            rPair = mergeSort(nums,temp,left,mid) + mergeSort(nums,temp,mid+1,right);
            
                for (int i = left, j = mid+1; i <= mid+1 && j <= right;){
                if (nums[i] > (long) nums[j] * 2){
                    rPair += mid - i + 1;
                    j++;
                }
                else i++;
            }
            
             merge(nums, left, right);
        }
        
        return rPair;
    }
    
    private void merge(int[] nums, int low, int high){
		int mid = (low+high) / 2;
		int[] arr = new int[high - low + 1];
		
		int i = low, j = mid + 1, k = 0;
		while (k < arr.length){
			int num1 = i > mid ? Integer.MAX_VALUE : nums[i];
			int num2 = j > high ? Integer.MAX_VALUE : nums[j];
			
			arr[k++] = num1 <= num2 ? nums[i++] : nums[j++];
		}
		
		for (int p = 0; p < arr.length; p++) nums[p+low] = arr[p];
	}
}