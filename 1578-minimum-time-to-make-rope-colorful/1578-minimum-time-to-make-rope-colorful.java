class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i = 0;
        int j = 0;
        
        int totalTime = 0;
        
        
        while(i < colors.length() && j < colors.length()){
            int currMax = 0;
        int currTotal = 0;
            
            while(j < colors.length() && colors.charAt(j) == colors.charAt(i)){
                currTotal += neededTime[j];
                currMax = Math.max(currMax, neededTime[j]);
                
                j++;
            }
            
            
            totalTime += currTotal - currMax;
            i++;
        }
        
        
        return totalTime;
    }
}