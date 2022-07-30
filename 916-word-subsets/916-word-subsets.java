class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] target = new int[26];
        List<String> result = new ArrayList<>();
        for(String pat : words2){
            int[] temp = new int[26];
            
            for(char ch : pat.toCharArray()){
                temp[ch-'a']++;
                target[ch-'a'] = Math.max(target[ch-'a'],temp[ch-'a']);
            }
        }
        
        for(String word : words1){
            int[] temp1 = new int[26];
            
            for(char ch : word.toCharArray()){
                temp1[ch-'a']++;
            }
            
            if(subset(temp1,target)){
                result.add(word);
            }
        }
        
        return result;
    }
    
    public boolean subset(int[] source, int[] dest){
        for(int i = 0; i < 26; i++){
            if(dest[i] > source[i])
                return false;
        }
        
        return true;
    }
}