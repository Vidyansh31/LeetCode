class Solution {
    public class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;
        
        Pair(int li, int di, int val){
            this.li = li;
            this.di = di;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> qu = new PriorityQueue<>();
        
        int max = 0;
        for(int i = 0; i < nums.size(); i++){
            qu.add(new Pair(i,0,nums.get(i).get(0)));
            max = Math.max(max,nums.get(i).get(0));
        }
        
        int rst = 0;
        int rend = 0;
        int size = Integer.MAX_VALUE;
        
        while(qu.size() == nums.size()){
            Pair rem = qu.remove();
            int currSize = max - rem.val;
            
            if(currSize < size){
                rst = rem.val;
                rend = max;
                size = currSize;
            }
            
            if(rem.di+1 < nums.get(rem.li).size()){
                int idx = rem.di +1;
                qu.add(new Pair(rem.li,rem.di+1,nums.get(rem.li).get(rem.di+1)));
                
                max = Math.max(max,nums.get(rem.li).get(rem.di+1));
            }
        }
        
        return new int[]{rst,rend};
    }
}