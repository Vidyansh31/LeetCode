class Solution {
    public String firstPalindrome(String[] words) {
        String s = "";
        for(int i = 0; i < words.length; i++){
            if(isPalindrome(words[i])){
                s = words[i];
                break;
            }
        }
        
        return s;
    }
    
    private boolean isPalindrome(String s){
        int i =0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}