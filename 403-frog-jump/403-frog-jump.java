class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        
        for(int stone : stones){
            map.put(stone, new HashSet<>());
        }
        
        map.get(stones[0]).add(1);
        
        for(int stone : stones){
            for(int jump : map.get(stone)){
                int next = jump+stone;
                if(jump+stone == stones[stones.length-1]){
                    return true;
                }
                
                if(map.containsKey(next)){
                    map.get(next).add(jump);
                    map.get(next).add(jump+1);
                    
                    if(jump-1 > 0){
                        map.get(next).add(jump-1);
                    }
                }
            }
        }
        
        return false;
    }
}