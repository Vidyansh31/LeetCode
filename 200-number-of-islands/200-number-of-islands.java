class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public int numIslands(char[][] grid) {
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        
        for(int[] d : dir){
            int row = i+d[0];
            int col = j + d[1];
            
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1'){
                dfs(grid,row,col);
            }
        }
    }
}