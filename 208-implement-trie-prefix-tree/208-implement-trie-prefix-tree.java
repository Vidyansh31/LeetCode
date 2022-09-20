class Node{
        Node[] links = new Node[26];
        boolean isEnd = false;
        
        boolean contains(char ch){
            return links[ch - 'a'] != null;
        }
        
        void put(char ch, Node node){
            links[ch-'a'] = node;
        }
        
        Node get(char ch){
            return links[ch - 'a'];
        }
        
        void setEnd(){
            isEnd = true;
        }
};
class Trie { 
            
private static Node root;
    public Trie() {
        root = new Node();
    }
    
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
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
            char ch = word.charAt(i);
            if(node.contains(ch) == false){
                return false;
            }
            
            node = node.get(ch);
        }
        
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
         Node node = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(node.contains(ch) == false){
                return false;
            }
            
            node = node.get(ch);
        }
        
        return true;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */