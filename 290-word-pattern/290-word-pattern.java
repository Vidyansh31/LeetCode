class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] ch = pattern.toCharArray();
        if(words.length != ch.length){
            return false;
        }
        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Boolean> map2 = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            char letter = ch[i];
            
            if(map1.containsKey(letter)){
                if(map1.get(letter).equals(word) == false){
                    return false;
                }
            }
            else if(map2.containsKey(word)){
                return false;
            }
            else{
                map1.put(letter,word);
                map2.put(word,true);
            }
        }
        
        return true;
    }
}