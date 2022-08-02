class Solution {
    public int maximumSwap(int num) {
        char[] arr = (num+"").toCharArray();
        int[] right = new int[arr.length];
        right[arr.length-1] = -1;
        
        for(int i = arr.length-2; i >=0; i--){
            if(i == arr.length-2){
                right[i] = arr.length-1;
            }
            else{
             right[i] = arr[i+1] > arr[right[i+1]] ? i+1 : right[i+1];
            }
        }
        
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] < arr[right[i]] ){
                char temp = arr[i];
                arr[i] = arr[right[i]];
                arr[right[i]] = temp;
                break;
            }
        }
        
        String res = new String(arr);
        return Integer.parseInt(res);
        
        
    }
}