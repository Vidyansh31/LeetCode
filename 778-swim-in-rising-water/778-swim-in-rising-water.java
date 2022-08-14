class Solution {
    public class Pair implements Comparable<Pair>{
        int x;
        int y;
        int time;
        
        Pair(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
        
        public int compareTo(Pair o){
            return this.time - o.time;
        }
    }
    
    public int swimInWater(int[][] grid) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        pq.add(new Pair(0,0,grid[0][0]));
        
        int time = -1;
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            
            if(vis[rem.x][rem.y] == true){
                continue;
            }
            vis[rem.x][rem.y] = true;
            
            time = Math.max(time,rem.time);
            if(rem.x == grid.length-1 && rem.y == grid[0].length-1){
                break;
            }
            
            addChild(grid,pq,vis,rem.x-1,rem.y);
            addChild(grid,pq,vis,rem.x,rem.y+1);
            addChild(grid,pq,vis,rem.x+1,rem.y);
            addChild(grid,pq,vis,rem.x,rem.y-1);
        }
        
        return time;
    }
    
    public void addChild(int[][] grid, PriorityQueue<Pair> pq, boolean[][] vis, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        else if(vis[i][j] == true){
            return;
        }
        
        pq.add(new Pair(i,j,grid[i][j]));
    }
}