class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(); 
        int n = num2.length();
        
        int[] pos = new int[m+n];
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j>= 0; j--){
                int mul = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                int carrypos = i+j;
                int sumpos = i+j+1;
                
                int sum = mul + pos[sumpos];
                
                pos[carrypos] += sum/10;
                pos[sumpos] = sum%10;
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int num : pos){
        if(!(sb.length() == 0 && num == 0)){
                sb.append(num);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}