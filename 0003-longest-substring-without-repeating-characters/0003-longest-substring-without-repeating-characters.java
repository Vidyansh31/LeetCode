class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        while(j < s.length()){
            char ch = s.charAt(j);
            if(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }
            else{
                set.add(ch);
                res = Math.max(res, set.size());
                j++;
                
            }
            
        }
               
        return res;
        
    }
}