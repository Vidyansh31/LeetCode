class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String normalize = paragraph.replaceAll("[^a-zA-Z0-9]"," ").toLowerCase();
        
        String[] words = normalize.split("\\s+");
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words){
            
            map.put(word, map.getOrDefault(word,0)+1);
        }
        System.out.println(map);
        Set<String> ban = new HashSet<>();
        for(String word : banned){
            ban.add(word);
        }
        
        String ans = "";
        int count = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(count < entry.getValue() && ban.contains(entry.getKey()) == false){
                count = entry.getValue();
                ans = entry.getKey();
            }
        }
        
        return ans;
    }
}