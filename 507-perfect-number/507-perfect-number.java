class Solution {
    public boolean checkPerfectNumber(int num) {
        int divisors = num/2;
        int sum = 0;
        
        while(divisors > 0){
            if(num%divisors == 0){
                sum += divisors;
            }
            divisors--;
        }
        
        return num == sum;
        
    }
}