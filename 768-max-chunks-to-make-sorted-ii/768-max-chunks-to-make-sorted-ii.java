class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] minfrmR = new int[n];
        minfrmR[n-1] = arr[n-1];
        
        for(int i = n-2; i >= 0; i--){
            minfrmR[i] = Math.min(arr[i],minfrmR[i+1]);
        }
        
        int res = 1;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length-1; i++){
            max = Math.max(arr[i],max);
            
            if(max <= minfrmR[i+1]){
                res++;
            }
        }
        
        return res;
    }
}