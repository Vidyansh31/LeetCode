class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target <= startFuel){
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int i = 0;
        int res = 0;
        int curr = startFuel;
        
        for(res = 0; curr < target ; res++){
            while(i < stations.length && stations[i][0] <= curr){
                pq.add(stations[i][1]);
                i++;
            }
            if(pq.size() == 0) return -1;
            curr += pq.remove();
        }
        
        return res;
        
        
        
    }
}