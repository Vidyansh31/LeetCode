class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
     List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
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
            if(vis[i] || i > 0 && nums[i] == nums[i-1]  && !vis[i-1]) continue;
            
            temp.add(nums[i]);
            vis[i] = true;
            helper(list,temp,nums,vis);
            vis[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}