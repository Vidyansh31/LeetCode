class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        
        for(String word : words){
            if(match(word,pattern))
                ans.add(word);
        }
        
        return ans;
    }
    
    public boolean match(String word, String pattern){
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Boolean> map2 = new HashMap<>();
        
        for(int i = 0; i < word.length(); i++){
            char ch1 = word.charAt(i);
            char ch2 = pattern.charAt(i);
            
            if(map1.containsKey(ch1)){
                if(map1.get(ch1) != ch2){
                    return false;
                }
            }
            else if(map2.containsKey(ch2)){
                return false;
            }
            else{
                map1.put(ch1,ch2);
                map2.put(ch2,true);
            }
        }
        
        return true;
        
    }
}