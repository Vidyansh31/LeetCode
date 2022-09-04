class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temp.length];
        for(int i = 0; i < temp.length; i++){
            while(st.size() > 0 && temp[i] > temp[st.peek()]){
                ans[st.peek()] = i - st.pop();
            }
            
            st.push(i);
        }
        
        while(st.size() > 0){
            ans[st.pop()] = 0;
        }
        
        return ans;
    }
}