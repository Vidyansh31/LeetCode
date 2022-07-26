class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(list,temp,nums,0);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        helper(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
    }
}