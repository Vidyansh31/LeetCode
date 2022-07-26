class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(list,temp,nums);
        return list;
    }
    
    private void helper(List<List<Integer>> list, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(temp.contains(nums[i]) == false){
                temp.add(nums[i]);
                helper(list,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}