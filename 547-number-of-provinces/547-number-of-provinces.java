class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] vis = new boolean[isConnected.length];
        
        for(int i = 0; i < isConnected.length; i++){
            if(vis[i] == false){
                count++;
                dfs(isConnected,i,vis);
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] graph, int vtx, boolean[] vis){
        vis[vtx] = true;
        
        
            for(int i = 0; i < graph[vtx].length; i++){
                if(graph[vtx][i] == 1&& vis[i] == false && i != vtx){
                    dfs(graph,i,vis);
                }
            }
        
    }
}