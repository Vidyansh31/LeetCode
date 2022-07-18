class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] sol = nextSmallestonLeft(heights);
        int[] sor = nextSmallestonRight(heights);
        
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int w = sor[i] - sol[i] -1;
            int area = heights[i]*w;
            max = Math.max(area,max);
        }
        
        return max;
    }
    
    private int[] nextSmallestonLeft(int[] arr){
        int[] ans = new  int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = arr.length-1; i>= 0; i--){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                ans[st.pop()] = i;
            }
            
            st.push(i);
            
        }
        
        while(st.size() != 0){
            ans[st.pop()] = -1;
        }
        
        return ans;
    }
    
     private int[] nextSmallestonRight(int[] arr){
        int[] ans = new  int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < arr.length; i++){
            while(st.size() > 0 && arr[st.peek()] > arr[i]){
                ans[st.pop()] = i;
            }
            
            st.push(i);
            
        }
        
        while(st.size() != 0){
            ans[st.pop()] = arr.length;
        }
        
        return ans;
    }
}