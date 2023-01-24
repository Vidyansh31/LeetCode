class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> qu = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        qu.add(1);
        int steps = 0;
        
        while(qu.size() > 0){
            int size = qu.size();
            
            while(size-- > 0){
                int x = qu.remove();
                
                if(x == n*n) return steps;
                
                for(int j = 1; j <= 6; j++){
                    if(x+j > n*n){
                        break;
                    }
                    
                    int[] pos = findCoordinate(x+j,n);
                    int r = pos[0];
                    int c = pos[1];
                    
                    if(vis[r][c]) continue;
                    
                    vis[r][c] = true;
                    
                    if(board[r][c] == -1){
                        qu.add(x+j);
                    }
                    else{
                        qu.add(board[r][c]);
                    }
                }
            }
            steps++;
        }
        
        
        return -1;
     
    }
    
    
    public int[] findCoordinate(int curr, int n){
        int r = n - (curr-1)/n - 1;
        int c = (curr-1)%n;
        
        if(r%2 == n%2){
            return new int[]{r,n-1-c};
        }
        else{
            return new int[]{r,c};
        }
    }
}