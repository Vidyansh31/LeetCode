class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        
        helper(list,temp,candidates,0,target);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> temp, int[] arr, int st, int tar){
       
           if(tar == 0 ){
               list.add(new ArrayList<>(temp));
               return;
           }
           
       
        
        for(int i = st; i < arr.length; i++){
            if(i > st && arr[i] == arr[i-1]){
                continue;
            }
            
            if(arr[i] > tar){
                break;
            }
            
            temp.add(arr[i]);
            helper(list, temp, arr, i+1,tar-arr[i]);
            temp.remove(temp.size()-1);
        }
        
        
    }
}