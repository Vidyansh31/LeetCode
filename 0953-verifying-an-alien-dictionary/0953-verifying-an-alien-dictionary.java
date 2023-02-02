class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // HashMap<Character,Integer> map = new HashMap<>();
        int[] map = new int[26];
        
        int k = 0;
        for(char ch : order.toCharArray()){
            map[ch-'a'] = k++;
        }
        
        for(int i = 0; i < words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            
            if(!compare(word1,word2,map)){
                return false;
            }
            
        }
        
        return true;
    }
    
    public boolean compare(String word1, String word2, int[] map){
        for(int j = 0; j < Math.min(word1.length(),word2.length()); j++){
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                
                if(ch1 != ch2){
                    int idx1 = map[ch1 - 'a'];
                    int idx2 = map[ch2 - 'a'];
                    
                    if(idx1 > idx2){
                        return false;
                    }
                    else{
                        return true;
                    }
                    
                }
        }
        if(word1.length() > word2.length()){
            return false;
        }
        return true;
    }
}