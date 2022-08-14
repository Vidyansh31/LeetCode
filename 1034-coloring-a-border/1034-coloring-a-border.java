class Solution {
    
    public class Pair{
        int x; 
        int y;
        int color;
        
        Pair(int x, int y, int color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int boxColor = grid[row][col];
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        traversalBFS(grid,vis,row,col,boxColor,color);
        
        return grid;
    }
    
    public void traversalBFS(int[][] grid, boolean[][] vis, int i, int j, int boxColor, int color){
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(i,j,boxColor));
        List<Integer> ans = new ArrayList<>();
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(vis[rem.x][rem.y] == true){
                continue;
            }
            vis[rem.x][rem.y] = true;
            
            if(isBorder(grid,rem.x,rem.y, boxColor)){
                ans.add(rem.x);
                ans.add(rem.y);
            }
            
            addChild(grid,qu,vis,rem.x-1,rem.y,boxColor);
            addChild(grid,qu,vis,rem.x,rem.y+1,boxColor);
            addChild(grid,qu,vis,rem.x+1,rem.y,boxColor);
            addChild(grid,qu,vis,rem.x,rem.y-1,boxColor);
        }
        
        for(int k = 0; k < ans.size(); k = k + 2){
            int x = ans.get(k);
            int y = ans.get(k+1);
            
            grid[x][y] = color;
        }
    }
    
    public void addChild(int[][] grid, Queue<Pair> qu, boolean[][] vis, int i, int j, int boxColor){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] == true || grid[i][j] != boxColor){
            return;
        }
        
        qu.add(new Pair(i,j,boxColor));
    }
    
   public boolean isBorder(int[][] grid, int i, int j, int boxColor ){
         if(i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1){
            return true; 
        }
        else if(grid[i-1][j] == boxColor && grid[i][j+1] == boxColor && grid[i+1][j] == boxColor && grid[i][j-1] == boxColor){
            return false;
        }
        else{
            return true;
        }
    }
}