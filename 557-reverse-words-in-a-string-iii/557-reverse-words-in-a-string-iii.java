class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
       
        for(int i = 0; i < arr.length; i++){
            arr[i] = reverse(arr[i]);
        }
       
        StringBuilder str = new StringBuilder("");
        
        for(int i = 0; i < arr.length; i++){
           str.append(arr[i]);
            if(i < arr.length-1){
                str.append(" ");
            }
       }
        
        return str.toString();
    }
    
    public String reverse(String s){
        char[] ch = s.toCharArray();
        
        for(int i = 0; i < ch.length/2; i++){
            char temp = ch[i];
            ch[i] = ch[ch.length-1-i];
            ch[ch.length-1-i] = temp;
        
        }
        
        s = String.valueOf(ch);
        return s;
        
    }
}