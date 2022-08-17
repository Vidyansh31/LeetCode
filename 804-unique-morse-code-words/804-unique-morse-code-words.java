class Solution {
    public String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        
        Set<String> set = new HashSet<>();
        
        for(String word : words){
            StringBuilder sb = new StringBuilder("");
            for(char ch : word.toCharArray()){
                sb.append(code[ch-'a']);
            }
            set.add(sb.toString());
        }
        
        return set.size();
    }
}