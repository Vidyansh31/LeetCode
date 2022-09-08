class Solution {
    public List<Integer> partitionLabels(String s) {
        int li = 0;
        int st = -1;
        
        int[] map = new int[26];
        
        //Storing last index of every character
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map[ch-'a'] > li){
                li = map[ch-'a'];
            }
            
            if(li == i){
                res.add(i-st);
                st = i;
            }
        }  
        
        return res;
    }
}