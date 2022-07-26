class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList();
        List<String> temp = new ArrayList<>();
        helper(list,temp,s,0);
        return list;
    }
    
    private void helper(List<List<String>> list, List<String> temp, String s, int idx){
        if(idx == s.length()){
            list.add(new ArrayList<>(temp));
        }
        
        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s.substring(idx,i+1))){
                temp.add(s.substring(idx,i+1));
                helper(list,temp,s,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}