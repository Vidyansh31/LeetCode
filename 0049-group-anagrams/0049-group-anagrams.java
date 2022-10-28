class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<HashMap<Character,Integer>, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            HashMap<Character,Integer> freq = new HashMap<>();
            
            for(char ch : str.toCharArray()){
                freq.put(ch, freq.getOrDefault(ch,0)+1);
            }
            
            if(map.containsKey(freq) == false){
                map.put(freq, new ArrayList<>());
            }
            
            map.get(freq).add(str);
        }
        
        
        List<List<String>> ans = new ArrayList<>();
        
        for(HashMap<Character,Integer> key : map.keySet()){
            ans.add(map.get(key));
        }
        
        
        return ans;
        
    }
}