class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temp.length];
        
        for(int i = 0; i < temp.length; i++){
            while(st.size() > 0 && temp[st.peek()] < temp[i]){
                int idx = st.pop();
                ans[idx] = i - idx;
            }
            
            st.push(i);
        }
        
        return ans;
    }
}