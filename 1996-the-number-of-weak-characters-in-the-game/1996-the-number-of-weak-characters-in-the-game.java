class Solution {
    public int numberOfWeakCharacters(int[][] prop) {
        int n = prop.length;
        
        Arrays.sort(prop, (a,b) ->{
            return a[0] == b[0] ? b[1] - a[1] :  a[0] - b[0];
        });
        
        int min = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i = n-1; i >= 0; i--){
            if(min > prop[i][1]){
                count++;
            }
            
            min = Math.max(min,prop[i][1]);
        }
        
        return count;
    }
}