class Solution {
    public class Pair{
        int i;
        int j;
        int level;
        
        Pair(int i, int j, int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        
        
        Queue<Pair> qu = new LinkedList<>();
        boolean found = false;
        for(int i = 0;i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid,qu,i,j);
                    found = true;
                    break;
                }
            }
            
            if(found){
                break;
            }
        }
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(vis[rem.i][rem.j] == true){
                continue;
            }
            vis[rem.i][rem.j] = true;
            
            if(grid[rem.i][rem.j] == 1){
                return rem.level-1;
            }
            
            addChild(grid,qu,vis,rem.i-1,rem.j,rem.level+1);
            addChild(grid,qu,vis,rem.i,rem.j+1,rem.level+1);
            addChild(grid,qu,vis,rem.i+1,rem.j,rem.level+1);
            addChild(grid,qu,vis,rem.i,rem.j-1,rem.level+1);
        }
        
        return -1;
    }
    
    public void dfs(int[][] grid, Queue<Pair> qu, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return;
        }
        
        grid[i][j] = 2;
        qu.add(new Pair(i,j,0));
        dfs(grid,qu,i-1,j);
        dfs(grid,qu,i,j+1);
        dfs(grid,qu,i+1,j);
        dfs(grid,qu,i,j-1);
    }
    
    public void addChild(int[][] grid, Queue<Pair> qu , boolean[][] vis, int i, int j , int level){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 2 || vis[i][j] == true){
            return;
        }
        
        qu.add(new Pair(i,j,level));
        
    }
}