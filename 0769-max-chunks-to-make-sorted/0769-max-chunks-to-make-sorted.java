class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(arr[i],max);
            if(max == i){
                res++;
            }
        }
        
        return res;
    }
}