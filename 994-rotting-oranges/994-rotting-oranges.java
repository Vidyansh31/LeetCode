class Solution {
    class Pair{
        int x;
        int y;
        int time;
        
        Pair(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> qu = new LinkedList<>();
        int fresh = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i,j,0));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        int time = 0;
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(vis[rem.x][rem.y]){
                continue;
            }
            
            vis[rem.x][rem.y] = true;
            
            time = Math.max(time,rem.time);
            if(grid[rem.x][rem.y] == 1){
                fresh--;
            }
            
            //add children
            addChild(qu,vis,grid,rem.x-1,rem.y,rem.time + 1);
            addChild(qu,vis,grid,rem.x,rem.y+1,rem.time + 1);
            addChild(qu,vis,grid,rem.x+1,rem.y,rem.time + 1);
            addChild(qu,vis,grid,rem.x,rem.y-1,rem.time + 1);
        }
        
        if(fresh == 0){
            return time;
        }
        
        return -1;
    }
    
    
    public void addChild(Queue<Pair> qu, boolean[][] vis, int[][] grid, int i, int j, int time){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] == true || grid[i][j] != 1){
            return;
        }
        
        qu.add(new Pair(i,j,time));
    }
}