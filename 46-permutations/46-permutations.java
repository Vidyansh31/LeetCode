class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        
        helper(list,nums,0);
        return list;
    }
    
    public void helper(List<List<Integer>> list,int[] nums, int idx){
        if(idx == nums.length){
            //Copy all into a list
            List<Integer> temp = new ArrayList<>();
            for(int num : nums){
                temp.add(num);
            }
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = idx; i < nums.length; i++){
            swap(nums,idx,i);
            helper(list,nums,idx+1);
            swap(nums,idx,i);
        }
    }
    
    public void swap(int[] nums, int idx, int i){
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
    }
}