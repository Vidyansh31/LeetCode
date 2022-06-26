class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxl = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while(i < s.length()){
            char ch = s.charAt(i);
            if(set.contains(ch) == false){
                set.add(ch);
                maxl = Math.max(maxl,set.size());
                i++;
            }
            else{
                set.remove(s.charAt(j));
                j++;
                
            }
        }
        
        return maxl;
    }
}