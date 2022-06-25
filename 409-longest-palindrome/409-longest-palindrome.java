class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch, 1);
            }
        }
        System.out.println(map);
        int len = 0;
        boolean oldFound = false;
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
           if(entry.getValue()%2 == 0){
               len += entry.getValue();
           }
            else{
                oldFound = true;
                len += entry.getValue() - 1;
            }
        }
            
        if(oldFound){
            return len + 1;
        }
        
        return len;
        
    }
}