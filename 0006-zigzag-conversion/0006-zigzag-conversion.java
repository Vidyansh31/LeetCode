class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder ans = new StringBuilder("");
        int n = s.length();
        int increment = 2*numRows - 2;
        
        for(int i = 0; i < numRows; i++){
            for(int j = i; j < n ; j += increment){
                ans.append(s.charAt(j));
                
                if(i > 0 && i < numRows - 1 && j + increment - 2*i < n){
                    ans.append(s.charAt(j+increment - 2*i));
                }
            }
        }
        
        
        return ans.toString();
    }
}