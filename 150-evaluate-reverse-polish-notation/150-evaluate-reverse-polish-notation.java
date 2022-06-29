class Solution {
    public int solve(int num1, int num2 ,char ch){
        if( ch == '+' ){
            return num1+num2;
        }
        else  if( ch == '-' ){
            return num1-num2;
        }
        else  if( ch == '*' ){
            return num1*num2;
        }
        else{
            return num1/num2;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        
        for(int i = 0; i < tokens.length; i++){
            if(Character.isDigit(tokens[i].charAt(0))){
                st.push(Integer.parseInt(tokens[i]));
            }
            else if(tokens[i].length() > 1 && Character.isDigit(tokens[i].charAt(1))){
                st.push(Integer.parseInt(tokens[i]));
            }
            else{
               int num2 = st.pop();
                int num1 = st.pop();
                char ch = tokens[i].charAt(0);
                
                st.push(solve(num1,num2,ch));
                
            }
            
        }
        return st.pop();
    }
}