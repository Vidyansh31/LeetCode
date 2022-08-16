class Solution {
    public String customSortString(String order, String s) {
        int[] map = new int[26];
        
        for(char ch : s.toCharArray()){
            map[ch-'a']++;
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < order.length(); i++){
            char ch = order.charAt(i);
            while(map[ch-'a']-- > 0){
                sb.append(ch);
            }
        }
        
        for(int i = 0; i < map.length; i++){
            while(map[i]-- > 0){
                sb.append((char)(i+'a'));
            }
        }
        
        return sb.toString();
    }
}