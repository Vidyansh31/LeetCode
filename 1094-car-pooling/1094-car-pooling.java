class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] map = new int[1001];
        int maxTo = 0;
        for(int[] trip : trips){
            int from = trip[1];
            int to = trip[2];
            maxTo = Math.max(to,maxTo);
            int people = trip[0];
            
            if(map[from] == 0){
                map[from] = people;
            }
            else{
                map[from] += people;
            }
            
            if(map[to] == 0){
                map[to] = -people;
            }
            else{
                map[to] += -people;
            }
        }
        
        int p = 0;
        for(int i = 0; i <= maxTo; i++){
            p += map[i];
            
            if(p > capacity){
                return false;
            }
        }
        
        return true;
    }
}