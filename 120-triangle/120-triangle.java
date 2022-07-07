class Solution {
    private Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new Integer[n][n];
        return helper(triangle,0,0);
    }
    
    public int helper(List<List<Integer>> triangle, int st, int level){
        if(level == triangle.size()-1){
            return triangle.get(level).get(st);
        }
        
        if(memo[level][st] != null ){
            return memo[level][st];
        }
        
        int I = helper(triangle,st,level+1);
        int I1 = helper(triangle,st+1,level+1);
        
        int sum  = triangle.get(level).get(st) + Math.min(I,I1);
        
        return memo[level][st] = sum;
    }
}