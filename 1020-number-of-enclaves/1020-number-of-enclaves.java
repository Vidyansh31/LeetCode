class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public int numEnclaves(int[][] grid) {
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i != 0 && j != 0 && i != grid.length-1 && j != grid[0].length-1){
                    continue;
                }
                else{
                    if(grid[i][j] == 1){
                        dfs(grid,i,j);
                    }
                }
                
            }
        }
        
        int count = 0;
        for(int[] row : grid){
            for(int land : row){
                if(land == 1){
                    count++;
                }
            }
        }
        
        return count;
    }
     
    
    public void dfs(int[][] grid, int i, int j){
        grid[i][j] = 0;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                dfs(grid,r,c);
            }
        }
    }
}