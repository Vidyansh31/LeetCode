class Solution {
    public String removeKdigits(String num, int k) {
        if(k == 0){
            return num;
        }
        
        if(k == num.length()){
            return "0";
        }
        
        Stack<Character> st = new Stack<>();
        st.push(num.charAt(0));
        
        for(int i = 1; i < num.length(); i++){
            char ch = num.charAt(i);
            
            while(st.size() > 0 && k > 0 && ch < st.peek()){
                st.pop();
                k--;
            }
            
            st.push(ch);
        }
        
        while(k > 0){
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder("");
        while(st.size() > 0){
            sb.append(st.pop());
        }
        
        for(int i = sb.length()-1; i >= 0; i--){
            if(sb.charAt(i) == '0'){
                sb.deleteCharAt(i);
            }
            else{
                break;
            }
        }
        
        return sb.length() == 0 ? "0" : sb.reverse().toString();
        
        
    }
}