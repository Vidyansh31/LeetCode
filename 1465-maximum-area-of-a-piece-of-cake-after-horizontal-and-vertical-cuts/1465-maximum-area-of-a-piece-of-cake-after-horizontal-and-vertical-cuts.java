class Solution {
    public int maxArea(int h, int w, int[] hC, int[] vC) {
        
        Arrays.sort(hC);
        Arrays.sort(vC);
        
        int maxHeight = Math.max(hC[0]-0, h - hC[hC.length-1]);
        for(int i = 1; i < hC.length; i++){
            int currHeight = hC[i] - hC[i-1];
            maxHeight = Math.max(currHeight,maxHeight);
        }
        
        
        int maxWidth = Math.max(vC[0]-0, w - vC[vC.length-1]);
        for(int i = 1; i < vC.length; i++){
            int currWidth = vC[i] - vC[i-1];
            maxWidth = Math.max(currWidth,maxWidth);
        }
        
        long maxArea = 1L * maxHeight * maxWidth;
        
        return (int)(maxArea%1000000007);
    }
}