class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        int i = 0;
        int j = 0;
        
        while(j < s.length()){
            while(i < s.length() && s.charAt(i) == ' '){
                i++;
            }
            
            j = i;
            
            while( j < s.length() && s.charAt(j) != ' '){
                j++;
            }
            
            st.push(s.substring(i,j));
            i = j;
        }
        
        StringBuilder sb = new StringBuilder();
        while(st.size() > 1){
            if(st.peek().length() == 0){
                st.pop();
            }
            else{
                 sb.append(st.pop() + " ");
            }
        }
        
        sb.append(st.pop());
        
        return sb.toString();
        
    }
}