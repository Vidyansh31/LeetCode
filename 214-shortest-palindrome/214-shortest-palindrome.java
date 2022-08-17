class Solution {
    public String shortestPalindrome(String s) {
        String str = s + "$" + new StringBuilder(s).reverse().toString();
        int[] lps = getLps(str);
        
        String toadd = new StringBuilder(s.substring(lps[str.length()-1])).reverse().toString();
        
        return toadd+s;
        
    }
    
    public int[] getLps(String s){
        int[] lps = new int[s.length()];
        int len = 0;
        int i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                lps[i] = len +1;
                len++;
                i++;
            }
            else if(len == 0){
                lps[i] = 0;
                i++;
            }
            else{
                len = lps[len-1];
            }
        }
        
        return lps;
    }
}