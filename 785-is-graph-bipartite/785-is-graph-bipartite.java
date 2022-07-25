class Solution {
    class Pair{
        int v; int color;
        
        Pair(int v, int color){
            this.v = v; 
            this.color = color;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(vis[i] == 0){
                boolean isBip = dfs(graph,i,vis,1);
                if(isBip == false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int[][] graph, int src, int[] vis, int color){
        vis[src] = color;
        
        for(int nbr : graph[src]){
            if(vis[nbr] == 0){
                boolean isbip = dfs(graph,nbr,vis,color*-1);
                if(isbip == false){
                    return false;
                }
            }
            else{
                if(vis[nbr] != color*-1){
                    return false;
                }
            }
        }
        
        return true;
    }
}