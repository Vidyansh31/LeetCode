class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,new ArrayList<>(),1,n,k);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> temp, int st, int n, int k){
        
        if(k == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        
       for(int i = st; i <= n; i++){
           temp.add(i);
           
           helper(list,temp,i+1,n,k-1);
           
           temp.remove(temp.size() -1);
           
       }
    }
}