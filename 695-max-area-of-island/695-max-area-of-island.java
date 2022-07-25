class Solution {
    public int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid,i,j);
                    
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    public int dfs(int[][] grid, int i , int j){
        int area = 1;
        grid[i][j] = 0;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                area += dfs(grid,r,c);
            }
        }
        return area;
    }
    
    
}