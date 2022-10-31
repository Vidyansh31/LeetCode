class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
       HashMap<Integer,Set<Integer>> map = new HashMap<>();
        
       for(int i = 0; i < matrix.length; i++){
           for(int j = 0; j < matrix[0].length; j++){
               int gap = i-j;
               
               if(map.containsKey(gap) == false){
                   map.put(gap, new HashSet<>());
               }
               
               map.get(gap).add(matrix[i][j]);
               
               if(map.get(gap).size() > 1){
                   return false;
               }
           }
       }
        
        return true;
    }
}