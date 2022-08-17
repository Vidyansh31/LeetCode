class Solution {
    public int superpalindromesInRange(String left, String right) {
        long l = Long.valueOf(left);
        long r = Long.valueOf(right);
        
        int count = 0;
        
        //Creating palindrome in range of 1 to 100000
        //Even Palindrome
        for(int i = 0; i <= 100000; i++){
            StringBuilder sb = new StringBuilder(i+"");
            for(int j = sb.length()-1; j >= 0; j--){
                sb.append(sb.charAt(j));
            }
            
             long n = Long.valueOf(sb.toString());
                n = n*n;

                if(n > r) break;
                if(n >= l && isPalindrome(n)) count++;
        }
        
       //Odd Palindrome
        for(int i = 0; i <= 100000; i++){
            StringBuilder sb = new StringBuilder(i+"");
            for(int j = sb.length()-2; j >= 0; j--){
                sb.append(sb.charAt(j));
            }
            
             long n = Long.valueOf(sb.toString());
                n = n*n;

                if(n > r) break;
                if(n >= l && isPalindrome(n)) count++;
        }
        
        return count;
        
    }
    
    public boolean isPalindrome(long n){
        long reverse = 0;
        while(reverse < n){
            reverse = reverse*10 + n%10;
            n = n/10;
        }
        
        return n == reverse || n == reverse/10;
    }
}