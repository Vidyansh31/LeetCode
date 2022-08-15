class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
       for(int[] edge : prerequisites){
           indegree[edge[0]]++;
       }
        
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                qu.add(i);
            }
        }
        
        int[] topo = new int[numCourses];
        int idx = 0;
        while(qu.size() > 0){
            int rem = qu.remove();
            topo[idx++] = rem;
            
            for(int[] edge : prerequisites){
                if(edge[1] == rem){
                    indegree[edge[0]]--;
                    
                    if(indegree[edge[0]] == 0){
                        qu.add(edge[0]);
                    }
                }
            }
        }
        if(idx < numCourses){
            return new int[]{};
        }
        return topo;
    }
}