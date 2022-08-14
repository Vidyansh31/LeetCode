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
        
        //Add all words int set from wordList
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(beginWord,1));
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            String str = rem.word;
            for(int i = 0; i < str.length(); i++){
                char wh = str.charAt(i);
                for(int j = 0; j < 26; j++){
                    char ch = (char)('a' + j);
                    if(ch == wh){
                        continue;
                    }
                    String s = str.substring(0, i) + ch
              + str.substring(i + 1);
                    

                    if(set.contains(s)){
                        if(s.equals(endWord)){
                            return rem.level+1;
                        }
                        qu.add(new Pair(s,rem.level+1));
                        set.remove(s);
                        
                    }
                }
            }
        }
        
        return 0;
    }
}