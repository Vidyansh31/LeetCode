class Solution {
    int peri = 0;
    
    public int islandPerimeter(int[][] grid) {
         
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j);
                    return peri ;
                }
            }
        }
        
        return peri;
    }
    
    public void dfs(int[][] grid, int sr, int sc){
        if(sr < 0|| sr >= grid.length || sc < 0 || sc >= grid[0].length || grid[sr][sc] == 0){
            peri++;
            return;
        }
        
        if(grid[sr][sc] == 2){
            return;
        }
        
        grid[sr][sc] = 2;
        
        dfs(grid,sr-1,sc);
        dfs(grid,sr,sc+1);
        dfs(grid,sr+1,sc);
        dfs(grid,sr,sc-1);
        
        
    }
}