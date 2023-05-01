class Solution {
    public double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        double total = salary[0];
        
        for(int i = 1; i < salary.length; i++){
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
            
            total += (double)salary[i];
        }
        
        
        total = total - (double)(max+min);
        
        return total / (salary.length - 2);
    }
}