class Solution {
    public void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                countZero++;
            }
            else if(nums[i] == 1){
                countOne++;
            }
            else{
                countTwo++;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(countZero > 0){
                nums[i] = 0;
                countZero--;
            }
            else if(countOne > 0){
                nums[i] = 1;
                countOne--;
            }
            else{
                nums[i] = 2;
                countTwo--;
            }
        }
        
    }
}