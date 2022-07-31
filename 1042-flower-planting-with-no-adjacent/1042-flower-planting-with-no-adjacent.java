class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] color = new int[n];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        //Assigning new arrayList to all vertex
        for(int i = 0; i < n; i++){
            graph.put(i,new ArrayList<>());
        }
        
        //Create Edges
        for(int[] p : paths){
            graph.get(p[0]-1).add(p[1]-1);
            graph.get(p[1]-1).add(p[0]-1);
        }
        
        boolean ans = helper(graph,0,color);
        return color;
    }
    
    public boolean helper(Map<Integer,List<Integer>> graph, int src, int[] color){
        if(src == graph.size()){
            return true;
        }
        
        for(int i = 1; i <= color.length; i++){
            if(possible(graph,src,color,i)){
                color[src] = i;
                
                if(helper(graph,src+1,color)){
                    return true;
                }
                color[src] = 0;
            }
        }
        return false;
    }
    
    public boolean possible(Map<Integer,List<Integer>> graph, int src, int[] color, int c){
        for(int nbr : graph.get(src)){
            if(color[nbr] == c){
                return false;
            }
        }
        return true;
    }
}