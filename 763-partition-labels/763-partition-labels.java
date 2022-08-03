class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        for(char ch : s.toCharArray()){
            map.put(ch,i);
            i++;
        }
        i = 0;
        List<Integer> ans = new ArrayList<>();
        
        
       int st = 0;
        int e = 0;
        
        for(i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            e = Math.max(e,map.get(ch));
            
            if(e == i){
                ans.add(e-st+1);
                e++;
                st=e;
            }
        }
      
        return ans;
    }
}