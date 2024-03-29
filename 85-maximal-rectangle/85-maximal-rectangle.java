class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] dp = new int[matrix[0].length];
        
        for(int j = 0; j < matrix[0].length; j++){
            dp[j] = matrix[0][j] - '0';
        }
        
        int max = largestArea(dp);
        
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    dp[j] = 0;
                }
                else{
                    dp[j] += matrix[i][j] - '0';
                }
            }
            
            int area = largestArea(dp);
            
            max = Math.max(area,max);
        }
        
        return max;
    }
    
     public int largestArea(int[] heights) {
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