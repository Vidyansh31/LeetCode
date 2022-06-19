class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    maxArea = area < maxArea ? maxArea : area;
                }
            }
        }
        
        return maxArea;
    }
    
    public int dfs(int[][] grid, int i, int j){
        grid[i][j] = 0;
        int area = 1;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1){
                int rArea = dfs(grid,r,c);
                area += rArea ;
            }
        }
        
        return area;
    }
}