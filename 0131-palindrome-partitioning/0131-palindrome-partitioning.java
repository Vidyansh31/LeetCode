class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(list,temp,s,0);
        return list;
    }
    
    public void helper(List<List<String>> list, List<String> temp, String s, int idx){
        if(idx == s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = idx; i < s.length(); i++){
            String str = s.substring(idx, i+1);
            if(isPalindrome(str)){
                temp.add(str);
                helper(list,temp,s,i+1);
                temp.remove(temp.size() - 1);
            }
        }
        
    }
    
    public boolean isPalindrome(String s){
        if(s.length() == 0){
            return false;
        }
        
        int i = 0;
        int j = s.length()-1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}