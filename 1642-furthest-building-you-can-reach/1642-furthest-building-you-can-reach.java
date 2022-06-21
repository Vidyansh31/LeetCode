class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        for(int i = 0; i < heights.length-1; i++){
            int gap = heights[i+1] - heights[i];
            if(gap > 0){
                qu.add(gap);
            }
            
            if(qu.size() > ladders){
                bricks -= qu.poll();
            }
            
            if(bricks < 0){
                return i;
            }
        }
        
        return heights.length-1;
    }
}