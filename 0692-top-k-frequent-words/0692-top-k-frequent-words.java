class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            if(map.get(a) == map.get(b)){
                return b.compareTo(a);
            }
            else{
                return map.get(a) - map.get(b);
            }
        });
        
        for(String word : map.keySet()){
            pq.add(word);
            
            if(pq.size() > k){
                pq.remove();
            }
        }
        
        List<String> ans = new LinkedList<>();
        while(pq.size() > 0){
           ans.add(0,pq.remove()); 
        }
        
        return ans;
    }
}