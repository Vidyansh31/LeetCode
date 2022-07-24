class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        
        Stack<String> st  = new Stack<>();
        
        for(String str : strs){
            if(str.equals("#")){
                while(st.size() > 0 && st.peek().equals("#")){
                    st.pop();
                    if(st.size() == 0) return false;
                    st.pop();
                }
            }
            
            st.push(str);
        }
        
        return st.size() == 1 && st.peek().equals("#");
    }
}