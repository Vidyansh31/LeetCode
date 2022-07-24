class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        //In starting we have one vacany for root
        int vacancy = 1;
        
        for(String str : strs){
            if(--vacancy < 0 ) return false;
            
            if(!str.equals("#"))            // whenever we encounter a new node left and right two vacancy for                                                                      that node will added in total
                vacancy += 2;
           
        }
        
        
        return vacancy == 0;
        
    }
}