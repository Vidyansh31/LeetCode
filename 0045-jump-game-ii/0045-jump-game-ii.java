class Solution {
    public int jump(int[] arr) {
         if(arr.length == 1){
            return 0;
        }
        
        if(arr[0] == 0){
            return -1;
        }
        
        int range = arr[0];
        int step = arr[0];
        int jump = 1;
        
        for(int i = 1; i < arr.length; i++){
            if( i == arr.length-1){
                return jump;
            }
            
            range = Math.max(range,i+arr[i]);
            step--;
            if(step == 0){
                jump++;
                if(range <= i){
                    return -1;
                }
                step = range - i;
            }
        }
        
        return -1;
    }
}