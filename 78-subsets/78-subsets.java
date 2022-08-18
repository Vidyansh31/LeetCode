class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(list,temp,nums,0);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> temp ,int[] nums, int idx){
        if(idx == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[idx]);
        helper(list,temp,nums,idx+1);
        temp.remove(temp.size()-1);
        helper(list,temp,nums,idx+1);
    }
}