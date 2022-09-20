class Solution {
    class Node{
        Node[] links = new Node[26];
        int ew = 0;
        int cp = 0;
        
        boolean contains(char ch){
            return links[ch - 'a'] != null;
        }
        
        void put(char ch, Node node){
            links[ch-'a'] = node;
        }
        
        Node get(char ch){
            return links[ch - 'a'];
        }
        
        void increasePrefix(){
            cp++;
        }
        
        void increaseEnd(){
            ew++;
        }
        
    }
    class Trie{
        private static Node root;
        
        Trie(){
            root = new Node();
        }
        
        public void insert(String word){
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                
                if(node.contains(ch) == false){
                    node.put(ch,new Node());
                }
                
                node = node.get(ch);
                node.increasePrefix();
            }
            
            node.increaseEnd();
        }
        
        public int count(String word){
            int ans = 0;
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                
                if(node.contains(ch) == false){
                    return 0;
                }
                
                node = node.get(ch);
                ans += node.cp;
            }
            
            return ans;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        Trie head = new Trie();
        
        for(String word : words){
            head.insert(word);
        }
        
        int[] res = new int[words.length];
        
        for(int i = 0; i < words.length; i++){
            res[i] = head.count(words[i]);
        }
        
        return res;
    }
}