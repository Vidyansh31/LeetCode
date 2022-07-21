class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int pair = 0;
        for(int val : time){
            int rem = val % 60;
            
            if(rem == 0){
                pair += arr[0];
            }
            else{
                pair += arr[60-rem];
            }
            
            arr[rem]++;
        }
        
        return pair;
        
    }
}