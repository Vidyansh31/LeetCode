 class Node{
        Node[] links = new Node[26];
        boolean isEnd = false;
        
        boolean contains(char ch){
            return links[ch - 'a'] != null;
        }
        
        void put(char ch,  Node node){
            links[ch - 'a'] = node;
        }
     
        Node get(char ch){
            return links[ch - 'a'];
        }
     
        void setEnd(){
            isEnd = true;
        }
        
}
class WordDictionary {
   private static Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char ch =  word.charAt(i);
            if(node.contains(ch) == false){
                node.put(ch, new Node());
            }
            
            node = node.get(ch);
        }
        
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char ch =  word.charAt(i);
            if(ch == '.'){
                boolean found = false;
                for(int j = 0; j < 26; j++){
                    if(node.links[j] != null){
                        found = dfs(word.substring(i+1),node.links[j]);
                        if(found){
                            return true;
                        }
                    }
                }
                return false;
            }
            else if(node.contains(ch) == false){
                return false;
            }
            node = node.get(ch);
        }
        
        return node.isEnd;
    }
    
    public boolean dfs(String s, Node node){
         for(int i = 0; i < s.length(); i++){
            char ch =  s.charAt(i);
            if(ch == '.'){
                boolean found = false;
                for(int j = 0; j < 26; j++){
                    if(node.links[j] != null){
                        found = dfs(s.substring(i+1),node.links[j]);
                        if(found){
                            return true;
                        }
                    }
                }
                return false;
            }
            else if(node.contains(ch) == false){
                return false;
            }
            node = node.get(ch);
        }
        
        return node.isEnd;
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */