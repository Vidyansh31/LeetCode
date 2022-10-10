class Solution {
    public String breakPalindrome(String palindrome) {
        char[] arr = palindrome.toCharArray();
        
        for(int i = 0; i < arr.length/2; i++){
            if(arr[i] != 'a'){
                arr[i] = 'a';
                return new String(arr);
            }
        }
        
         arr[arr.length - 1] = 'b'; //if all 'a'
        return arr.length < 2 ? "" : String.valueOf(arr);
    }
}