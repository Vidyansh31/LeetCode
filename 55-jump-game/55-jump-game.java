class Solution {
    public boolean canJump(int[] arr) {
         if(arr.length == 1){
            return true;
        }
        
        if(arr[0] == 0){
            return false;
        }
        
        int range = arr[0];
        int step = arr[0];
        int jump = 1;
        
        for(int i = 1; i < arr.length; i++){
            if( i == arr.length-1){
                return true;
            }
            
            range = Math.max(range,i+arr[i]);
            step--;
            if(step == 0){
                jump++;
                if(range <= i){
                    return false;
                }
                step = range - i;
            }
        }
        
        return false;
    }
}