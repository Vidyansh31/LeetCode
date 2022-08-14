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
        
        //Start bfs with beginWord
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(beginWord,1));
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            String str = rem.word;
            //Loop over every character of str and change it by [a,z]
            // if change word is present in set, then
            for(int i = 0; i < str.length(); i++){
                char wh = str.charAt(i);
                for(int k = 'a'; k <= 'z'; k++){
                    char arr[] = str.toCharArray();
                    arr[i] = (char) k;
                        
                    String s = new String(arr);
            
                    if(set.contains(s)){
                        // check if that word is equals to endWord if equal return curr level + 1
                        // else add in queue and remove from set
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