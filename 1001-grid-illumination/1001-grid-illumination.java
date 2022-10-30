class Solution {
    public int[][] dir = {
        {0,0},
        {-1,0},
        {-1,1},
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {0,-1},
        {-1,-1}
    };
    
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer,Integer> xmap = new HashMap<>();
        HashMap<Integer,Integer> ymap = new HashMap<>();
        HashMap<Integer,Integer> xpymap = new HashMap<>();
        HashMap<Integer,Integer> xmymap = new HashMap<>();
        HashMap<Integer,Boolean> lamp = new HashMap<>();
        
        for(int i = 0; i < lamps.length; i++){
            int x = lamps[i][0];
            int y = lamps[i][1];
            if(lamp.containsKey(x*n + y) == false){
                xmap.put(x, xmap.getOrDefault(x,0)+1);
                ymap.put(y, ymap.getOrDefault(y,0)+1);
                xpymap.put(x+y, xpymap.getOrDefault(x+y,0)+1);
                xmymap.put(x-y, xmymap.getOrDefault(x-y,0)+1);
                lamp.put(x*n+y, true);
            }
        }
        
        int[] ans = new int[queries.length];
        
        for(int k = 0; k < queries.length; k++){
            int x = queries[k][0];
            int y = queries[k][1];
            
            ans[k] = 0;
            if(xmap.getOrDefault(x,0) >0){
                ans[k] = 1; 
            }
            else if(ymap.getOrDefault(y,0) >0){
                ans[k] = 1; 
            }
            else if(xpymap.getOrDefault(x+y,0) >0){
                ans[k] = 1; 
            }
            else if(xmymap.getOrDefault(x-y,0) >0){
                ans[k] = 1; 
            }
            
            
            for(int[] d : dir){
                int i = x+d[0];
                int j = y + d[1];
                
                if(lamp.containsKey(i*n+j)){
                    xmap.put(i, xmap.getOrDefault(i,0)-1);
                    ymap.put(j, ymap.getOrDefault(j,0)-1);
                    xpymap.put(i+j, xpymap.getOrDefault(i+j,0)-1);
                    xmymap.put(i-j, xmymap.getOrDefault(i-j,0)-1);
                    lamp.remove(i*n+j);
                }
            }
        }
        
        return ans;
        
    }
}