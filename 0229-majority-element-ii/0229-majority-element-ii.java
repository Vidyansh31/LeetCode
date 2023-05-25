class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int num1 = -99999;
        int num2 = -99999;
        int c1 = 0;
        int c2 = 0;
        
        for(int el : nums){
            if(el == num1){
                c1++;
            }
            else if(el == num2){
                c2++;
            }
            else if(c1 == 0){
                num1 = el;
                c1++;
            }
            else if(c2 == 0){
                num2 = el;
                c2++;
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