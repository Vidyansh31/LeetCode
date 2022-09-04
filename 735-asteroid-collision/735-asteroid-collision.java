class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < ast.length; i++){
            if(st.size() == 0){
                st.push(ast[i]);
            }
           else if(st.peek() < 0){
               st.push(ast[i]);
           }
           else if(ast[i] > 0){
               st.push(ast[i]);
           }
            else{
                while(st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(ast[i])){
                   st.pop();
                }
                
                if(st.size() == 0){
                    st.push(ast[i]);
                }
                else if(st.peek() < 0){
                    st.push(ast[i]);
                }
                else if(st.peek() == Math.abs(ast[i])){
                    st.pop();
                }
            }
        }
        
        
        int[] ans = new int[st.size()];
        int k = st.size() -1;
        while(st.size() > 0){
            ans[k--] = st.pop();
        }
        
        return ans;
    }
}