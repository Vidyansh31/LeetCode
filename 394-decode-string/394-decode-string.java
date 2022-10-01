class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> count = new Stack<>();
        Stack<String> st = new Stack<>();
        int idx = 0;
        
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int c = 0;
                while(Character.isDigit(s.charAt(idx))){
                    c = c*10 + (s.charAt(idx) - '0');
                    idx++;
                }
                count.push(c);
            }
            else if(s.charAt(idx) == '['){
                st.push(res);
                res = "";
                idx++;
            }
            else if(s.charAt(idx) == ']'){
               StringBuilder temp = new StringBuilder(st.pop());
                int repeated = count.pop();
                for(int i = 0; i < repeated;i++){
                    temp.append(res);
                }
                
                res = temp.toString();
                idx++;
            }
            else{
                res += s.charAt(idx);
                idx++;
            }
            
        }
                      
                      return res;
        
    }
}