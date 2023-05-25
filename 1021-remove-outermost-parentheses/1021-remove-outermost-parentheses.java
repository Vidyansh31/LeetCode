class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        
        int opened = 0;
        
        for(char c : s.toCharArray()){
            if(c == '(' && opened++ > 0) sb.append("(");
            if(c == ')' && opened-- > 1) sb.append(")");
        }
        
        return sb.toString();
        
    }
}