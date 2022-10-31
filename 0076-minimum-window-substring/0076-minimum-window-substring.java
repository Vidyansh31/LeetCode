class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < 0 || s.length() < t.length()){
            return "";
        }
        
        HashMap<Character,Integer> tmap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tmap.put(ch, tmap.getOrDefault(ch,0)+1);
        }
        
        HashMap<Character,Integer> smap = new HashMap<>();
        int count = 0; // this count the valid character or character we are needing
        int j = -1;
        String res = "";
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch,0)+1);
            
            if( smap.getOrDefault(ch,0) <=  tmap.getOrDefault(ch,0)){
                count++;
            }
            
            //release
            while(count == t.length() && j < i){
                String ans = s.substring(j+1,i+1);
                if(res.length() == 0 || res.length() > ans.length()){
                    res = ans;
                }
                
                j++;
                char chr = s.charAt(j);
                smap.put(chr, smap.get(chr)-1);
                if( smap.getOrDefault(chr,0) <  tmap.getOrDefault(chr,0)){
                        count--;
                }
            }
            
        }
        
        return res;
    }
}