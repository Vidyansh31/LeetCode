class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        
        if(s.length() < 0 && s.length() < p.length()){
            return list;
        }
        
        int[] pmap = new int[26];
        for(char ch : p.toCharArray()){
            pmap[ch - 'a']++;
        }
        
        int[] smap = new int[26];
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            smap[ch-'a']++;
            
            //if valid increase count
            if(smap[ch-'a'] <= pmap[ch-'a']){
                count++;
            }
            
            //release
            if(i >= p.length()){
                char chr = s.charAt(i-p.length());
                smap[chr-'a']--;
                
                if(smap[chr-'a'] < pmap[chr-'a']){
                    count--;
                 }   
            }
            
            if(count == p.length()){
                list.add(i-p.length()+1);
            }
        }
        
        return list;
    }
}