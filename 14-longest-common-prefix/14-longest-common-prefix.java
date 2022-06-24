class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder cpre = new StringBuilder("");
        
        int i = 0;
        while(i < strs[0].length()){
            char pre = strs[0].charAt(i);
            
            for(String s : strs){
                
                if(i >= s.length() || pre != s.charAt(i)){
                    return cpre.toString();
                }
            }
            
            cpre.append(pre);
            i++;
        }
        
        
        return cpre.toString();
    }
}