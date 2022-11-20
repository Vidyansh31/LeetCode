class Solution {
    public int balancedString(String s) {
        int[] map1 = new int[26];
        
        for(char ch : s.toCharArray()){
            map1[ch - 'A']++;
        }
        
        int reqr = 0;
        int len = s.length()/4;
        for(char ch : "QWER".toCharArray()){
            if(map1[ch - 'A'] > len ){
                map1[ch-'A'] -= len;
                reqr += map1[ch-'A'];
            }
            else{
                map1[ch-'A'] = 0;
            }
        }
        
        
        if(reqr == 0){
            return 0;
        }
        
        int[] map2 = new int[26];
        int j = -1;
        int count = 0;
        int res = 0;
        
        for(int i = 0; i < s.length(); i++){
             char ch = s.charAt(i);
             map2[ch-'A']++;
            if(map1[ch-'A'] >= map2[ch-'A']){
                count++;
            }
            
            while(j < i && count == reqr){
                if(res == 0){
                    res = i-j;
                }
                else{
                    res = Math.min(res,i-j);
                }
                
                j++;
                char cha = s.charAt(j);
                map2[cha-'A']--;
                if(map1[cha-'A'] > map2[cha-'A']){
                    count--;
                }
            }
        }
        
        
        return res;
    }
}