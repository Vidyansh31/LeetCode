class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[n-1] = dominoes.charAt(n-1) == 'L' ? 1 : 0;
        //left force
        for(int i = n-2; i >= 0; i--){
            char ch = dominoes.charAt(i);
            
            if(ch == 'R'){
                left[i] = 0;
            }
            else if(ch == 'L'){
                left[i] = 1;
            }
            else{
                left[i] = left[i+1] > 0 ? left[i+1]+1 : 0;
            }
        }
        
        //right force
        right[0] = dominoes.charAt(0) == 'R' ? 1 : 0;
        
        for(int i = 1; i < n; i++){
             char ch = dominoes.charAt(i);
            
            if(ch == 'L'){
                right[i] = 0;
            }
            else if(ch == 'R'){
                right[i] = 1;
            }
            else{
                right[i] = right[i-1] > 0 ? right[i-1]+1 : 0;
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n; i++){
            if(left[i] == 0 && right[i] == 0){
                sb.append(".");
            }
            else if(left[i] == 0){
                sb.append("R");
            }
            else if(right[i] == 0){
                sb.append("L");
            }
            else{
                if(left[i] < right[i]){
                    sb.append("L");
                }
                else if(left[i] > right[i]){
                    sb.append("R");
                }
                else{
                    sb.append(".");
                }
            }
        }
       
        
        return sb.toString();
    }
} 