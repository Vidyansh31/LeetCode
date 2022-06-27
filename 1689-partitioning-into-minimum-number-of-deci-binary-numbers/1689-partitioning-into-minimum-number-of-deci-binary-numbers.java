class Solution {
    public int minPartitions(String n) {
        if(n.length() == 0){
            return 0;
        }
        
        int minPar = 0;
        
        for(char c : n.toCharArray()){
            int digit = Character.getNumericValue(c);
            minPar = Math.max(minPar,digit);
        }
        
        return minPar;
    }
}