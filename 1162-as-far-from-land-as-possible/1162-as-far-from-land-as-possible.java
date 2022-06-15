class Solution {
    
     public class Pair{
        int i; 
        int j;
        int level;
        
        Pair(int i, int j, int level){
            this.i=i;
            this.j=j;
            this.level = level;
        }
    }
    
    
    public int maxDistance(int[][] mat) {
        
         Queue<Pair> qu = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    qu.add(new Pair(i,j,0));
                }
            }
        }
        
        int maxDist = -1;
         boolean[][] visited = new boolean[mat.length][mat[0].length];
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            
           if(maxDist < rem.level && rem.level != 0){
               maxDist = rem.level;
           }
            
            addN(rem.i-1,rem.j,rem.level+1,qu,mat,visited);
            addN(rem.i,rem.j+1,rem.level+1,qu,mat,visited);
            addN(rem.i+1,rem.j,rem.level+1,qu,mat,visited);
            addN(rem.i,rem.j-1,rem.level+1,qu,mat,visited);
        }
        
        return maxDist;
    }
    
      public void addN(int i, int j, int level, Queue<Pair> qu, int[][] mat , boolean[][] visited){
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 1 || visited[i][j] == true ){
            return;
        }
        
        qu.add(new Pair(i,j,level));
    }
}