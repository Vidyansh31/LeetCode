class Solution {
    public void rotate(int[] nums, int k) {
         if(nums.length== 0){
             return;
         }
        int n = nums.length;
        k = k % n;
        if(k < 0){
            k = k + n;
        }
        
        
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
        
    }
    
    public void reverse(int[] arr, int st, int end){
        
        while(st < end){
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }
}