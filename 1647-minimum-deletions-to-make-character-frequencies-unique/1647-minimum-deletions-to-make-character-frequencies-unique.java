class Solution {
    public int minDeletions(String s) {
       if(s.length() == 0){
           return 0;
       }
        
        //count frequency of character
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        
        int deletion = 0;
        Set<Integer> set = new HashSet<>();
        for(int count : freq){
            while(count != 0 && set.contains(count)){
                deletion++;
                count--;
            }
            set.add(count);
        }
        
        return deletion;
        
    }
}