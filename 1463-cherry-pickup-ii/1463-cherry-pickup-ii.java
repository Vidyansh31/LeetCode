class Solution {
    public int cherryPickup(int[][] grid) {
        //As row and two columns are changing we need 3D dp
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        
        //We start from n-1 and go to 0 row 
        
        for(int i = grid.length-1; i >= 0 ; i--){
            for(int j1 = 0; j1 < grid[0].length; j1++){
                for(int j2 = 0; j2 < grid[0].length; j2++){
                   if(i == grid.length-1){
                        if(j1 == j2){
                            dp[i][j1][j2] = grid[i][j1];
                        }
                        else{
                            dp[i][j1][j2] = grid[i][j1]+grid[i][j2];
                        }
                    }
                    else {
                         int maxi = 0;
                        for(int dj1 = -1; dj1 <= 1; dj1++){
                            for(int dj2 = -1; dj2 <= 1; dj2++){
                                int value = 0;
                                if(j1+dj1 >= 0 && j1+dj1 < grid[0].length && j2+dj2 >= 0 && j2+dj2 < grid[0].length ){
                                    if(j1 == j2){
                                        value = grid[i][j1];
                                    }
                                    else{
                                        value = grid[i][j1]+ grid[i][j2]; }
                                    
                                    value += dp[i+1][j1+dj1][j2+dj2];
                                }
                                else{
                                    value = -(int)1e9;
                                }
                                
                                maxi = Math.max(value,maxi);
                            }
                        }
                        
                        dp[i][j1][j2] = maxi;
                    }
                }
            }
        }
        
        
        return dp[0][0][grid[0].length-1];
        
    }
    }
  