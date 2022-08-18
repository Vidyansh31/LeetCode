class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        helper(list,temp,nums,vis);
        return list;
    }
    
    public void helper(List<List<Integer>> list,List<Integer> temp ,int[] nums, boolean[] vis){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(vis[i] == false){
                temp.add(nums[i]);
                vis[i] = true;
                helper(list,temp,nums,vis);
                vis[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}