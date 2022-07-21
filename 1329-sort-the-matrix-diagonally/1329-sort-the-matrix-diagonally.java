class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int gap = i-j;
                
                if(map.containsKey(gap) == false){
                    map.put(gap,new PriorityQueue<>());
                }
                
                map.get(gap).add(mat[i][j]);
            }
        }
        
         for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int gap = i-j;
                
                mat[i][j] = map.get(gap).remove();
            }
        }
        
        return mat;
    }
}