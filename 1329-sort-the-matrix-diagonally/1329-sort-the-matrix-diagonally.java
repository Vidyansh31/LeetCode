class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int gap = i-j;
                
                if(map.containsKey(gap)){
                    map.get(gap).add(mat[i][j]);
                }
                else{
                    map.put(gap, new PriorityQueue<>());
                    map.get(gap).add(mat[i][j]);
                }
            }
        }
        
        //remove
         for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int gap = i-j;
                mat[i][j] = map.get(gap).remove();
            }
        }
        return mat;
    }
}