class Solution {
    public class Pair{
        String word;
        int level;
        
        Pair(String word, int level){
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.contains(endWord) == false){
            return 0;
        }
        
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(beginWord,1));
        
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        
        while(qu.size() > 0){
            Pair p = qu.remove();
            String rem = p.word;
            
            
            for(int i = 0; i < rem.length(); i++){
                char[] carr = rem.toCharArray();
                
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if(ch != rem.charAt(i)){
                        carr[i] = ch;
                        
                        String word = new String(carr);
                        // System.out.println(word);
                        
                        if(word.equals(endWord)){
                            return p.level+1;
                        }
                        
                        if(set.contains(word)){
                            qu.add(new Pair(word,p.level+1));
                            set.remove(word);
                            
                            
                        }
                    }
                }
            }   
        }
        
        return 0;
    }
}