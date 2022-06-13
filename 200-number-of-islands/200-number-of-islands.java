class Solution {
    int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
    
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int i , int j ){
        grid[i][j] = '0';
        
        for(int[] d : dir){
            int r = i+d[0];
            int c = j+d[1];
            
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1'){
                dfs(grid,r,c);
            }
        }
    }
}