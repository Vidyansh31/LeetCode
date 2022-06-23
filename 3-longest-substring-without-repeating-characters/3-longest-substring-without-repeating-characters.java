class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0 , j = 0 , maxl = 0;
        Set<Character> set = new HashSet<>();
        
        while(j < s.length()){
            char ch = s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                maxl = Math.max(maxl,set.size());
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return maxl;
    }
}