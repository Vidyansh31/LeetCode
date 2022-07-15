class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid,i,j,vis);
                    
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid, int i, int j, boolean[][] vis){
        
        int rv = 1;
        vis[i][j] = true;
        
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && vis[r][c] != true){
                rv += dfs(grid,r,c,vis);
            }
        }
        
        
        return rv;
    }
}