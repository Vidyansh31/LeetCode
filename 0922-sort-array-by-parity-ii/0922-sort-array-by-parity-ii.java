class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int even = 0;
        int odd = 1;
        
        for(int num : nums){
            if(num%2 == 0){
                res[even] = num;
                even += 2;
            }
            else{
                res[odd] = num;
                odd += 2;
            }
        }
        
        return res;
    }
}