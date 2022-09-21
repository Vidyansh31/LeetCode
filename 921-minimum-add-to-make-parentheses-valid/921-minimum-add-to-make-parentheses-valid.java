class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }
            else{
                if(st.size() == 0){
                    count++;
                    continue;
                }
                
                if(st.peek() != '('){
                    count++;
                }
                else{
                    st.pop();
                }
            }
        }
        
        count += st.size();
        
        return count;
    }
}