class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        n = n%14;
        if(n == 0) n += 14;
        for(int i = 0; i < n; i++){
            int[] curr = new int[8];
            curr[0] = 0;
            curr[7] = 0;
            for(int j = 1; j < 7; j++){
                if(cells[j-1] == cells[j+1]){
                    curr[j] = 1;
                }
                else{
                    curr[j] = 0;
                }
            }
            cells = curr;
        }
        
        return cells;
    }
}