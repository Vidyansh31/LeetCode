class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int[] e : edges){
            map.put(e[0],map.getOrDefault(e[0],0)+1);
            map.put(e[1],map.getOrDefault(e[1],0)+1);
        }
        
        int max = 0;
        int ans = 0;
        for(int n : map.keySet()){
            if(map.get(n) > max){
                max = map.get(n);
                ans = n;
            }
        }
        
        return ans;
    }
}