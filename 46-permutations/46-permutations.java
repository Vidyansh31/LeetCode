class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;;
        List<List<Integer>> list = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        helper(list, new ArrayList<>(),vis, nums, n);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> temp, boolean[] vis, int[] nums, int n){
        if(temp.size() == n){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        
        for(int i = 0; i < n; i++){
            if(vis[i] != true){
                temp.add(nums[i]);
                vis[i] = true;
                helper(list,temp,vis, nums, n);
                temp.remove(temp.size() - 1);
                vis[i] = false;
            }
        }
    }
    
    
}