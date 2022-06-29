class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int gridColor = image[sr][sc];
        if(gridColor == color){
            return image;
        }
        
        dfs(image,sr,sc,color,gridColor);
        
        return image;
    }
    
    public void dfs(int[][] image, int i , int j , int color , int gridColor){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != gridColor){
            return;
        }
        
        image[i][j] = color;
        
        dfs(image,i-1,j,color,gridColor);
        dfs(image,i,j+1,color,gridColor);
        dfs(image,i+1,j,color,gridColor);
        dfs(image,i,j-1,color,gridColor);
    }
}