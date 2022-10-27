class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        if(event2[0].compareTo(event1[1]) <= 0 && event2[1].compareTo(event1[0]) >= 0  ){
            return true;
        }
        
    
        
        return false;
    }
}