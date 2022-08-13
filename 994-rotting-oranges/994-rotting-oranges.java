class Solution {
    
    
    public class Pair{
        int x; int y; int t;
        
        Pair(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        Queue<Pair> qu = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i,j,0));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(vis[rem.x][rem.y] == true){
                continue;
            }
            vis[rem.x][rem.y] = true;
            time = rem.t;
            if(grid[rem.x][rem.y] == 1){
                fresh--;
            }
            
            addChild(grid,qu,vis,rem.x-1,rem.y,rem.t+1);
            addChild(grid,qu,vis,rem.x,rem.y+1,rem.t+1);
            addChild(grid,qu,vis,rem.x+1,rem.y,rem.t+1);
            addChild(grid,qu,vis,rem.x,rem.y-1,rem.t+1);
        }
        
        if(fresh == 0){
            return time;
        }
        
        return -1;
    }
    
    public void addChild(int[][] grid, Queue<Pair> qu,boolean[][] vis , int i, int j, int t){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        else if(vis[i][j] == true){
            return;
        }
        else if(grid[i][j] != 1){
            return;
        }
        
        qu.add(new Pair(i,j,t));
    }
}