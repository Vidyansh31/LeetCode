class Solution {
    static int[] parent;
    static int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        
        parent = new int[edges.length+1];
        rank = new int[edges.length+1];
        
        for(int i = 1; i <= edges.length; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int[] edge : edges){
            int src = edge[0];
            int nbr = edge[1];
            
            int srcLead = find(src);
            int nbrLead = find(nbr);
            
            if(srcLead != nbrLead){
                union(srcLead,nbrLead);
            }
            else{
                return edge;
            }
        }
        
        return new int[]{};
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int s1, int s2){
        if(rank[s1] < rank[s2]){
            parent[s1] = s2;
        }
        else if(rank[s1] > rank[s2]){
            parent[s2] = s1;
        }
        else{
            parent[s1] = s2;
            rank[s2]++;
        }
    }
}




