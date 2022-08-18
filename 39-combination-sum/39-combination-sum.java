class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(list,temp,candidates,0, target);
        return list;
    }
    
    public void helper(List<List<Integer>> list,List<Integer> temp, int[] arr, int idx, int target){
        if(idx == arr.length){
            if(target == 0){
                list.add(new ArrayList<>(temp));
            }
            return;
        }
        
        
        if(arr[idx] <= target){
            temp.add(arr[idx]);
            helper(list,temp,arr,idx,target-arr[idx]);
            temp.remove(temp.size()-1);
        }
        helper(list,temp,arr,idx+1,target);
    }
}