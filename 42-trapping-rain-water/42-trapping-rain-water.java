class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        left[0] = height[0];
        for(int i = 1; i < left.length; i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        
        int[] right = new int[height.length];
        right[height.length-1] = height[height.length-1];
        for(int j = height.length-2; j >= 0; j--){
            right[j] = Math.max(right[j+1],height[j]);
        }
        
        int waterSaved = 0;
        for(int i = 0 ; i < height.length; i++){
            waterSaved += Math.min(left[i],right[i]) - height[i];
        }
        
        return waterSaved;
    }
}