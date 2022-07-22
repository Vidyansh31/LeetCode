class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return ksum(nums,0,0,3);
    }
    
    private List<List<Integer>> ksum(int[] nums, int tar, int start, int k){
        List<List<Integer>> res = new ArrayList<>();
        if(start == nums.length){
            return res;
        }
        
        //check for average value
        int avg_value = tar/k;
        
        if(nums[start] > avg_value && nums[nums.length-1] < avg_value){
            return res;
        }
        
        if( k == 2){
            return twoSum(nums,tar,start);
        }
        
        for(int i = start; i < nums.length; i++){
            if(i == start || nums[i-1] != nums[i]){
                for(List<Integer> subset : ksum(nums, tar- nums[i], i+1,k-1)){
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size()-1).addAll(subset);
                }
            }
        }
        
        return res;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int tar, int start){
        List<List<Integer>> res = new ArrayList<>();
        int lo = start; int hi = nums.length-1;
        
        while(lo < hi){
            int currSum = nums[lo]+nums[hi];
            
            if(currSum < tar || lo > start && nums[lo-1] == nums[lo]){
                lo++;
            }
            else if(currSum > tar || hi < nums.length-1 && nums[hi+1] == nums[hi]){
                hi--;
            }
            else{
                res.add((Arrays.asList(nums[lo++],nums[hi--])));
            }
        }
        
        return res;
    }
}