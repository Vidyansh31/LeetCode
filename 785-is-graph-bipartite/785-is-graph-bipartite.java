class Solution {
    public class Pair{
        int v;
        int color;  // 1 : red , -1 : blue
        
        Pair(int v, int color){
            this.v = v;
            this.color = color;
        }
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for(int v = 0; v < graph.length; v++){
            if(visited[v] == 0){
                boolean isBip = traversal(graph,v,visited);
                
                if(!isBip){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean traversal(int[][] graph, int v, int[] visited){
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(v,1));
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(visited[rem.v] != 0){
                if(visited[rem.v] != rem.color){
                    return false;
                }
            }
            visited[rem.v] = rem.color;
            
            for(int nbr : graph[rem.v]){
                if(visited[nbr] == 0){
                    qu.add(new Pair(nbr,rem.color*-1));
                }
            }
            
        }
        
        return true;
    }
    
    
}