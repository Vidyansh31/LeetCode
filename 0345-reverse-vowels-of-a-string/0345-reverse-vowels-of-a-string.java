class Solution {
   public static final String vowels = "aeiouAEIOU";
    
    public String reverseVowels(String s) {
        int st = 0; 
        int end = s.length()-1;
        char[] array = s.toCharArray();
        
        while(st < end){
            
            while(st < end && vowels.indexOf(array[st]) == -1){
                st++;
            }
            
            while(st < end && vowels.indexOf(array[end]) == -1){
                end--;
            } 
            
            char temp = array[st];
            array[st] = array[end];
            array[end] = temp;
            st++;
            end--;
        }
        
        return new String(array);
    }
}