class Solution {
    public boolean areNumbersAscending(String s) {
        int i = 0;
        int prev = 0;
        int curr = 0;
        
        while(i < s.length()){
            
            while(i < s.length() && !Character.isDigit(s.charAt(i))){
                i++;
            }
            
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                int c = s.charAt(i) - '0';
                curr = curr * 10 + c;
                i++;
            }
            
            
            if( curr != 0 && curr <= prev){
                return false;
            }
            
            prev = curr;
            curr = 0;
        }
        
        
        return true;
    }
}