class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxi = 0;
        int n = heights.length;
        for(int i = 0; i <= n; i++){
            while(st.size() > 0 && (i == n || heights[st.peek()] >= heights[i])){
                int h = heights[st.pop()];
                
                int width = 0;
                
                if(st.size() == 0) width = i;
                else width = i - st.peek()-1;
                
                maxi = Math.max(maxi,h*width);
            }
            st.push(i);
        }
        
        
        return maxi;
    }
}