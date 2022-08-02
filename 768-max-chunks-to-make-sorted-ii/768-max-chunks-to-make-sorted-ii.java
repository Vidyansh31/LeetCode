class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] minFromRight = new int[arr.length];
        minFromRight[arr.length-1] = arr[arr.length-1];
        
        for(int i = arr.length-2; i >= 0; i--){
            minFromRight[i] = Math.min(arr[i],minFromRight[i+1]);
        }
        
        int res = 1;
        int max = -1;
        for(int i = 0; i < arr.length-1; i++){
            max = Math.max(arr[i],max);
            
            if(max <= minFromRight[i+1]){
                res++;
            }
        }
        
        return res;
    }
}