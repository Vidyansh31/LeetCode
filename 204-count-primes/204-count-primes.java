class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        
        for(int i = 2; i < n; i++){
            prime[i] = true;
        }
        
        for(int i = 2; i < n; i++){
            if(prime[i] == false){
                continue;
            }
            
            int x = 2;
            while(x*i < n){
                prime[x*i] = false;
                x++;
            }
        }
        
        int count = 0; 
        for(int i = 0; i < n; i++){
            if(prime[i] == true){
                count++;
            }
        }
        
        return count;
    }
}