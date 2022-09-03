class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        
        for(int num : map.keySet()){
            pq.offer(num);
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[] res = new int[k];
        int i = k-1;
        while(pq.size() > 0){
            res[i--] = pq.poll();
        }
        
        return res;
    }
}