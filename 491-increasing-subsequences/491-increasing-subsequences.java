class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        helper(nums,0,-1,set,temp);
        
        
         list.addAll(set);
        
        return list;
    }
    
    public void helper(int[] nums, int idx, int prev_idx, Set<List<Integer>> set, List<Integer> temp){
        if(idx == nums.length){
            if(temp.size() >= 2) set.add(new ArrayList<>(temp));
            return;
        }
        
        helper(nums,idx+1,prev_idx,set,temp);
        
        if(prev_idx == -1 || nums[idx] >= nums[prev_idx] ){
            temp.add(nums[idx]);
            helper(nums,idx+1,idx,set,temp);
            temp.remove(temp.size() - 1);
        }
    }
}