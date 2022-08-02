class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = (n+"").toCharArray();
        
        int dipPoint = -1;
        
        //Find Dip point where the increasing pattern breaks
        for(int i = arr.length-1; i > 0; i--){
            if(arr[i] > arr[i-1]){
                dipPoint = i-1;
                break;
            }
        }
        
        if(dipPoint == -1){
            return -1;
        }
        
        //Swap the element at dipPoint with just greater element from right
        for(int i = arr.length-1; i > dipPoint; i--){
            if(arr[dipPoint] < arr[i]){
                //swap them
                swap(arr,dipPoint,i);
                break;
            }
        }
        
        //now reverse from dipPoint+1 to end;
        int lo = dipPoint+1;
        int hi = arr.length-1;
        
        while(lo <= hi){
            swap(arr,lo,hi);
            lo++;
            hi--;
        }
        
     String s = new String(arr);
    long val = Long.parseLong(s);
        
        return val > Integer.MAX_VALUE ? -1 : (int)val;
    }
    
    public void swap(char[] arr, int lo, int hi){
        char temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }
    
   
    
}