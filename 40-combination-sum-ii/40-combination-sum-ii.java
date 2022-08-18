class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(list,temp,candidates,0, target);
        return list;
    }
    
    public void helper(List<List<Integer>> list,List<Integer> temp, int[] arr, int idx, int target){
        if(target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        
        for(int i = idx ; i < arr.length; i++){ 
            if(i != idx && arr[i] == arr[i-1]){
                continue;
            }
            
            
            
            if(arr[i] <= target){
                temp.add(arr[i]);
                helper(list,temp,arr,i+1,target-arr[i]);
                temp.remove(temp.size()-1);
            }
            
        }
    }
    
}