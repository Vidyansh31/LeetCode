class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> ans = new ArrayList<>();
        int k = pat.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        
        for(char ch : pat.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        
        int count = map.size();
        
        while(j < txt.length()){
           if(j - i + 1 < k){
               char t = txt.charAt(j);
               if(map.containsKey(t)){
                   map.put(t,map.get(t)-1);
                   if(map.get(t) == 0){
                       count--;
                   }
               }
               j++;
           }
           if(j - i + 1 == k){
                char t = txt.charAt(j);
                if(map.containsKey(t)){
                    map.put(t,map.get(t)-1);
                    if(map.get(t) == 0){
                        count--;
                    }
                }
                
                if(count == 0) ans.add(i);
                
                char p = txt.charAt(i);
                if(map.containsKey(p)){
                    map.put(p,map.get(p)+1);
                    if(map.get(p) == 1){
                        count++;
                    }
                }
                
                i++;
                j++;
           }
           
        }
        return ans;
    }
}