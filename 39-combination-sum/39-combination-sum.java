class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(list,temp,candidates,0,target);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> temp, int[] c ,int st, int tar){
        if(tar < 0){
            return ;
        }
        
        if(tar == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        
        
        for(int i = st; i < c.length; i++){
            temp.add(c[i]);
            helper(list,temp,c,i,tar-c[i]);
            temp.remove(temp.size() - 1);
        }
    }
}