class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        
       for(int col = 0; col < strs[0].length(); col++){
           for(int row = 1; row < strs.length; row++){
               char prev = strs[row-1].charAt(col);
               char curr = strs[row].charAt(col);
               
               if(prev - '0' > curr - '0'){
                   res++;
                   break;
               }
           }
       }
        
        return res;
    }
}