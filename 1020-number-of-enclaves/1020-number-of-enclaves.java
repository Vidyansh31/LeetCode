class Solution {
    boolean flag = true;
    int len =0;
    public int numEnclaves(int[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        
         for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == false && grid[i][j] == 1){
                    flag = true;
                    len = 0;
                    dfs(grid,visited,i,j);
                    if(flag == true){
                        count += len;
                    }
                    
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int[][] grid , boolean[][] visited, int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ){
            flag = false;
            return;
        }
        else if(grid[i][j] == 0){
            return;
        }
        else if(visited[i][j] == true){
            return;
        }
        
        
        len++;
        // System.out.println(len);
        visited[i][j] = true;
        dfs(grid,visited,i+1,j);
        dfs(grid,visited,i-1,j);
        dfs(grid,visited,i,j+1);
        dfs(grid,visited,i,j-1);
    }
}