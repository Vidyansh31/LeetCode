class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> availabiltyMap = new HashMap<>();
        Map<Integer,Integer> vacancyMap = new HashMap<>();
        
        for(int num : nums){
            availabiltyMap.put(num, availabiltyMap.getOrDefault(num,0)+1);
        }
        
        for(int i = 0;  i < nums.length; i++){
            if(availabiltyMap.get(nums[i]) <= 0){
                continue;
            }
            else if(vacancyMap.getOrDefault(nums[i],0) > 0){
                availabiltyMap.put(nums[i],availabiltyMap.get(nums[i])-1);
                
                vacancyMap.put(nums[i],vacancyMap.get(nums[i])-1);
                vacancyMap.put(nums[i]+1,vacancyMap.getOrDefault(nums[i]+1,0)+1);
            }
            else if(availabiltyMap.getOrDefault(nums[i],0) > 0 && availabiltyMap.getOrDefault(nums[i]+1,0) > 0 && availabiltyMap.getOrDefault(nums[i]+2,0) > 0){
                availabiltyMap.put(nums[i],availabiltyMap.get(nums[i])-1);
                availabiltyMap.put(nums[i]+1,availabiltyMap.get(nums[i]+1)-1);
                availabiltyMap.put(nums[i]+2,availabiltyMap.get(nums[i]+2)-1);
                
                vacancyMap.put(nums[i]+3,vacancyMap.getOrDefault(nums[i]+3,0)+1);
            }
            else{
                return false;
            }
            
        }
        
        return true;
        
    }
}