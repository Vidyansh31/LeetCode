class Solution {
    public class Pair{
        int i;
        int j;
        boolean border;
        
        Pair(int i, int j, boolean border){
            this.i = i;
            this.j = j;
            this.border = border;
        }
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Queue<Pair> qu = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int boxColor = grid[row][col];
        
        qu.add(new Pair(row,col,border(row,col,grid,boxColor)));
        
        List<Pair> ans = new ArrayList<>();
        
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            if(rem.border == true){
                ans.add(rem);
            }
            
            addN(rem.i-1,rem.j,grid,visited,qu,boxColor);
            addN(rem.i,rem.j+1,grid,visited,qu,boxColor);
            addN(rem.i+1,rem.j,grid,visited,qu,boxColor);
            addN(rem.i,rem.j-1,grid,visited,qu,boxColor);
        }
        
        for(Pair p : ans){
            grid[p.i][p.j] = color;
        }
        
        return grid;
    }
    
    public void addN(int i, int j, int[][] grid, boolean[][] visited, Queue<Pair> qu, int boxColor){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] != boxColor){
            return;
        }
        
        qu.add(new Pair(i,j,border(i,j,grid,boxColor)));
    }
    
    public boolean border(int i, int j , int[][] grid, int boxColor ){
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