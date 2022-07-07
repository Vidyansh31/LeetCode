class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < graph.length; i++){
            boolean safe = dfs(i,graph,vis);
            if(safe){
                res.add(i);
            }
        }
        
        return res;
    }
    
    public boolean dfs(int v , int[][] graph, int[] vis){
        if(vis[v] == 2){
            return true;
        }
        else if(vis[v] == 1){
            return false;
        }
        else{
            vis[v] = 1;
            for(int n : graph[v]){
                boolean isNbrSafe = dfs(n,graph,vis);
                if(!isNbrSafe){
                    return false;
                }
            }
        }
        
        vis[v] = 2;
        return true;
    }
}