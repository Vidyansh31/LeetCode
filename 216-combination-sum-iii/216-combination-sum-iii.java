class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(),k, n,1);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> temp, int k, int n, int num){
        
        
        if(k == 0 && n == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = num; i <= 9; i++){
            temp.add(i);
            helper(list,temp,k-1,n-i,i+1);
            temp.remove(temp.size()-1);
            
        }
        
    }
}