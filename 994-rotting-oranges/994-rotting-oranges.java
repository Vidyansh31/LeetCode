class Solution {
    public class Pair{
        int x;
        int y;
        int t;
        
        Pair(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> qu = new LinkedList<>();
        int fresh = 0;
        
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
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int time = 0;
        
        while(qu.size() > 0){
            //remove
            Pair rem = qu.remove();
            
            if(visited[rem.x][rem.y] == true){
                continue;
            }
            visited[rem.x][rem.y] = true;
            
            //work
            time = rem.t;
            
            if(grid[rem.x][rem.y] == 1){
                fresh--;
            }
            
            addNeighbours(rem.x+1,rem.y,visited,grid,qu,rem.t+1);
            addNeighbours(rem.x-1,rem.y,visited,grid,qu,rem.t+1);
            addNeighbours(rem.x,rem.y+1,visited,grid,qu,rem.t+1);
            addNeighbours(rem.x,rem.y-1,visited,grid,qu,rem.t+1);
        }
        
        if(fresh == 0){
            return time;
        }
        else{
            return -1;
        }
    }
    
    public void addNeighbours(int i, int j, boolean[][] visited, int[][] grid, Queue<Pair> qu, int t){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        else if(visited[i][j] == true){
            return;
        }
        else if(grid[i][j] == 0){
            return;
        }
        
        qu.add(new Pair(i,j,t));
    }
    
}