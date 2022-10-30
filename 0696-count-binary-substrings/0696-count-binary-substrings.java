class Solution {
    public int countBinarySubstrings(String s) {
        int currLen = 1;
        int prevLen = 0;
        int res = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currLen++;
            }
            else{
                res += Math.min(currLen, prevLen);
                prevLen = currLen;
                currLen = 1;
            }
        }
        
        return res + Math.min(currLen, prevLen);
        
    }
}