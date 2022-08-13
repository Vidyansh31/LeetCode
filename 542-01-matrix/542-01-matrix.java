class Solution {
    public class Pair{
        int x;
        int y;
        int level;
        
        Pair(int x, int y, int level){
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> qu = new LinkedList<>();
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    qu.add(new Pair(i,j,0));
                }
            }
        }
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(vis[rem.x][rem.y] == true){
                continue;
            }
            vis[rem.x][rem.y] = true;
            
            mat[rem.x][rem.y] = rem.level;
            
            addChild(mat,qu,vis,rem.x-1,rem.y,rem.level+1);
            addChild(mat,qu,vis,rem.x,rem.y+1,rem.level+1);
            addChild(mat,qu,vis,rem.x+1,rem.y,rem.level+1);
            addChild(mat,qu,vis,rem.x,rem.y-1,rem.level+1);
        }
        
        return mat;
    }
    
    public void addChild(int[][] mat, Queue<Pair> qu, boolean[][] vis, int i, int j, int level){
        if( i < 0 || i >= mat.length || j < 0 || j >= mat[0].length){
            return;
        }
        else if(vis[i][j]){
            return;
        }
        else if(mat[i][j] == 0){
            return;
        }
        
        qu.add(new Pair(i,j,level));
    }
}