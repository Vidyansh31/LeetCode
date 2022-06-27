class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int gridColor = image[sr][sc];
            if(gridColor == color){
                return image;
            }
            dfs(image,sr,sc,color,gridColor);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int color, int gridColor){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != gridColor){
            return;
        }
        
        
        image[sr][sc] = color;
        
        dfs(image,sr-1,sc,color,gridColor);
        dfs(image,sr,sc+1,color,gridColor);
        dfs(image,sr+1,sc,color,gridColor);
        dfs(image,sr,sc-1,color,gridColor);
    }
}