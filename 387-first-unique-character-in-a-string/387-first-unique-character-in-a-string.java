class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for(char ch : s.toCharArray()){
            map[ch - 'a']++;
        }
        
       for(int i = 0; i < s.length(); i++){
           char ch = s.charAt(i);
           if(map[ch - 'a'] == 1){
               return i;
           }
       }
        
        return -1;
    }
}