class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int len = 0;
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                if(st.size() == 1){
                    st.push(i);
                }
                else{
                    if(s.charAt(st.peek()) == '('){
                        st.pop();
                        len = i - st.peek();
                        maxlen = Math.max(len, maxlen);
                    }
                    else{
                        st.push(i);
                    }
                }
            }
        }
        
        return maxlen;
    }
}