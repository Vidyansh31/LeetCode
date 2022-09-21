class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder("");
        StringBuilder t1 = new StringBuilder("");
        
        helper(s,s1);
        helper(t,t1);
       
        return s1.toString().equals(t1.toString());
    }
    
    public void helper(String s, StringBuilder sb){
        for(char ch : s.toCharArray()){
            if(ch != '#'){
                sb.append(ch);
            }
            else {
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}