class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(graph, 0, graph.length-1, paths, path);
        return paths;
    }
    
    public void helper(int[][] graph, int src, int dest, List<List<Integer>> list, List<Integer> path){
        if(src == dest){
            path.add(dest);
            list.add(new ArrayList<>(path));
            return;
        }
        
        path.add(src);
        for(int nbr : graph[src]){
            helper(graph,nbr,dest,list,path);
            path.remove(path.size() - 1);
        }
        
    }
}