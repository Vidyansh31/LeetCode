class Solution {
    class Pair implements Comparable<Pair>{
        int plant;
        int grow;
        
        Pair(int plant, int grow){
            this.plant = plant;
            this.grow = grow;
        }
        
        public int compareTo(Pair o){
            return this.grow - o.grow;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < plantTime.length; i++){
            pq.add(new Pair(plantTime[i],growTime[i]));
        }
        
        int start = 0;
        int ans = 0;
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            start += rem.plant;
            ans = Math.max(ans, start+rem.grow);
        }
        
        return ans;
    }
}