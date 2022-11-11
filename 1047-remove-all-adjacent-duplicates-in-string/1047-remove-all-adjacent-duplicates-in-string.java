class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder("");
        sb.append(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++){
            if(sb.length() > 0 && s.charAt(i) == sb.charAt(sb.length()-1)){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}