class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        
        
        dfs(rooms,vis,0);
        
        for(int i = 0; i < rooms.size(); i++){
            if(vis[i] == false){
                return false;
            }
        }
        
        return true;
        
        
    }
    
    public void dfs(List<List<Integer>> rooms, boolean[] vis, int src){
        vis[src] = true;
        
        for(int nbr : rooms.get(src)){
            if(vis[nbr] != true){
                dfs(rooms,vis,nbr);
            }
        }
    }
}