class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map[ch-'a'] = i;
        }
        
        int st = 0;
        int end = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            end = Math.max(end,map[ch-'a']);
            
            if(end == i){
                ans.add(end-st+1);
                st = ++end;
            }
        }
        
        return ans;
    }
}