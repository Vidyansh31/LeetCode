class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int j = 0;
        
        while(j < pushed.length){
            st.push(pushed[j]);
            
            while(st.size() > 0 && st.peek() == popped[i]){
                st.pop();
                i++;
            }
            j++;
        }
        
        System.out.println(st);
        
       while(st.size() > 0 &&st.peek() == popped[i]){
           st.pop();
           i++;
       }
        
        return st.size() == 0;
    }
}