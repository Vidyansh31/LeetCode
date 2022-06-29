class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int digit = 0;
        boolean neg = false;
        
        //Trim white spaces
        while(i < s.length() && Character.isWhitespace(s.charAt(i))){
            i++;
        }
        
        //get sign of digit + or -
        if(i < s.length() && s.charAt(i) == '-'){
            neg = true;
            i++;
        }
        else if(i < s.length() && s.charAt(i) == '+'){
            i++;
        }
        
        //get digit
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int c = Character.getNumericValue(s.charAt(i));
            if((digit > Integer.MAX_VALUE/10) || digit == Integer.MAX_VALUE/10 && c > 7){
                if(neg){
                    return Integer.MIN_VALUE;
                }
                else{
                    return Integer.MAX_VALUE;
                }
            }
            digit = digit * 10 + c;
            i++;
        }
        
        if(digit == 0){
            return 0;
        }
        else if(neg){
            return -digit;
        }
        else{
            return digit;
        }
    }
}