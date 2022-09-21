class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int num : asteroids){
            if(st.size() == 0){
                st.push(num);
            }
            else if(st.peek() < 0){
                st.push(num);
            }
            else if(num > 0){
                st.push(num);
            }
            else{
                while(st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(num)){
                    st.pop();
                }
                
                if(st.size() == 0){
                    st.push(num);
                }
                else if(st.peek() < 0){
                    st.push(num);
                }
                else if(st.peek() == Math.abs(num)){
                    st.pop();
                }
            }
        }
        
        int[] ans = new int[st.size()];
        int i = st.size() -1 ;
        while(st.size() > 0){
            ans[i--] = st.pop();
        }
        return ans;
    }
}