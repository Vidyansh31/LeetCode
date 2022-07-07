class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        rank = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(List<Integer> pair : pairs){
            int x = pair.get(0);
            int y = pair.get(1);
            
            int xLead = find(x);
            int yLead = find(y);
            
            if(xLead != yLead){
                union(xLead,yLead);
            }
        }
        
         PriorityQueue<Character>[] pq = new PriorityQueue[s.length()];
        for(int i = 0; i < s.length(); i++){
            pq[i] = new PriorityQueue<>();
        }
        
        for(int i = 0; i < s.length(); i++){
            int il = find(i);
            char ch = s.charAt(i);
            pq[il].add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int il = find(i);
            char ch = pq[il].remove();
            sb.append(ch);
        }
        
        
        return sb.toString();
    }
    int[] parent;
    int[] rank;
    
    int find(int x){
        if(parent[x] == x){
            return x;
        } 
        else{
            int cp = find(parent[x]);
            parent[x] = cp;
            return parent[x];
        }
    }
    
    void union(int s1, int s2){
        if(rank[s1] < rank[s2]){
            parent[s1] = s2;
        }
        else if(rank[s2] < rank[s1]){
            parent[s2] = s1;
        }
        else{
            parent[s1] = s2;
            rank[s2]++;
        }
    }
}