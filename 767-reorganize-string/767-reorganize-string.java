class Solution {
    public String reorganizeString(String s) {
        int[] map = new int[26];
        
        for(char ch : s.toCharArray()){
            map[ch - 'a']++;
            
            if(map[ch-'a'] > (s.length()+1)/2){
                return "";
            }
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((x1,x2) -> {
            return map[x2 - 'a'] -  map[x1 - 'a'];
        });
        
        for(int i = 0; i < 26; i++){
            if(map[i] > 0){
                pq.add((char)('a'+i));
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        char prev = '.';
    
        while(pq.size() > 0){
            char rem = pq.remove();
            map[rem-'a']--;
            System.out.println(rem + " " + map[rem-'a']);
            sb.append(rem);
            
            if(prev != '.'){
                if(map[prev - 'a'] > 0){
                    pq.add(prev);
                }
            }
            prev = rem;
        }
        
        return sb.toString();
    }
}