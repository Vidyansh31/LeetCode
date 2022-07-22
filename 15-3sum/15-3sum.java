class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i-1] != nums[i]){
                int lo = i+1; int hi = nums.length-1; int sum = -nums[i];
                
                while(lo < hi){
                    int currSum = nums[lo]+nums[hi];
                    
                    if(currSum == sum){
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        
                        while(lo < hi && nums[lo+1] == nums[lo]) lo++;
                        while(lo < hi && nums[hi-1] == nums[hi]) hi--;
                        
                        lo++;
                        hi--;
                    }
                    else if(currSum < sum){
                        lo++;
                    }
                    else{
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}