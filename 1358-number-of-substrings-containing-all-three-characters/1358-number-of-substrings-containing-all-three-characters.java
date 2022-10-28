class Solution {
    public int numberOfSubstrings(String s) {
        return atMost(s,3) - atMost(s,2);
    }
    
    int atMost(String s , int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int j = -1;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
            
            while(j < i && map.size() > k){
                j++;
                char cj = s.charAt(j);
                if(map.get(cj) == 1){
                    map.remove(cj);
                }
                else{
                    map.put(cj, map.get(cj)-1);
                }
            }
            
            res += (i-j);
        }
        
        return res;
        
    }
}