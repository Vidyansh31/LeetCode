class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        
        for(char ch : ransomNote.toCharArray()){
            map[ch-'a']++;
        }
        
        for(int i = 0; i < magazine.length(); i++){
            char ch = magazine.charAt(i);
            if(map[ch-'a'] > 0){
                map[ch-'a']--;
            }
        }
        
        
        for(int count : map){
            if(count > 0){
                return false;
            }
        }
        
        return true;
    }
}