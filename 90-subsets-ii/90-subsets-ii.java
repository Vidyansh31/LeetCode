class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        helper(list,temp,nums,0);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> temp, int[] nums, int idx){
        
        list.add(new ArrayList<>(temp));
        
        
        for(int i = idx; i < nums.length; i++){
            if( i > idx && nums[i] == nums[i-1]){
                continue;
            }
            
            temp.add(nums[i]);
            helper(list,temp, nums, i+1);
            temp.remove(temp.size() - 1);
            
        }
        
        
    }
}