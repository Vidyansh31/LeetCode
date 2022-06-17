class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //There are atmost 2 elements than can appear more than n/3 times in an array
        //so we apply Moore Voting Algorithm
        int num1 = -9999999;                  // this will be our first candidate
        int num2 = -9999999;                  // this will be our Second Candidate
        int c1 = 0;
        int c2 = 0;                  // respective counts of number of appearences in array
        
        for(int el : nums){
            if(el == num1) 
                c1++;
            else if(el == num2){
                c2++;
            }
            else if(c1 == 0){
                num1 = el;
                c1 = 1;
            }
            else if(c2 == 0){
                num2 = el;
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        
        
        //Now check if num1 and num2 are our potential answers or not
        List<Integer> ans = new ArrayList<>();
        c1 = 0;
        c2 = 0;
        for(int el : nums){
            if(el == num1){
                c1++;
            }
            
            if(el == num2){
                c2++;
            }
        }
        
        if(c1 > nums.length/3){
            ans.add(num1);
        }
        
        if(c2 > nums.length/3){
            ans.add(num2);
        }
        
        return ans;
    }   
}