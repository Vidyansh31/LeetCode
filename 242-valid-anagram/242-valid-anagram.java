class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch : t.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        
        
        int count = map.size();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                
                if(map.get(ch) == 0){
                    count--;
                }
            }
        }
        
        if(count != 0) return false;
        
        return true;
    }
}