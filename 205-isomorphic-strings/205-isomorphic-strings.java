class Solution {
    public boolean isIsomorphic(String s, String t) {
        //Take 2 hashMap
        // keep track of characters of 1st string with their respective replacement
        HashMap<Character,Character> map1 = new HashMap<>(); 
        
        //keep track of 2nd String character as they are used previously or not;
        HashMap<Character,Boolean> map2 = new HashMap<>();
        
        
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map1.containsKey(ch1)){
                if(map1.get(ch1) != ch2){
                    return false;
                }
            }
            else if(map2.containsKey(ch2)){
                return false;
            }
            else{
                map1.put(ch1,ch2);
                map2.put(ch2,true);
            }
        }
        
        return true;
    }
}