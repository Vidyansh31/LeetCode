class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> {
            return b[1] - a[1];
        });
        
        int maxLoad = 0;
        for(int i = 0; i < boxTypes.length; i++){
            if(truckSize <= 0){
                break;
            }
            else{
              int unit_taken = Math.min(boxTypes[i][0],truckSize);
                
                maxLoad += unit_taken * boxTypes[i][1];
                
                truckSize = truckSize - unit_taken;
            }
        }
        
        return maxLoad;
            
    }
}