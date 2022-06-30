class Solution {
    public int fib(int n) {
        int prev = 0;
        int curr = 1;
        
        if(n <= 1){
            return n;
        }
        
        for(int i = 0; i < n; i++){
            int next = prev + curr;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}