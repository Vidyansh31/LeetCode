class Solution {
    public int numRescueBoats(int[] p, int limit) {
       Arrays.sort(p); 
        int count = 0;
        
        int i = 0;
        int j = p.length-1;
        while(i < j){
            if(p[i]+p[j] <= limit){
                i++;
                j--;
                count++;
            }
            else{
                count++;
                j--;
            }
        }
        
        if(i==j){
            count++;
        }
        
        return count;
    }
}