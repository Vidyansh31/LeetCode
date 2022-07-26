class Solution {
    public String getPermutation(int n, int k) {
        
        List<Integer> num = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            num.add(i);
        }
        
        StringBuilder sb = new StringBuilder("");
        helper(num,sb,k-1,n);
        return sb.toString();
    }
    
    private void helper(List<Integer> num, StringBuilder sb, int k, int n){
        if(num.size() == 1){
            sb.append(num.get(0)+"");
            return;
        }
        
        int f = fact(n-1);
        int idx = k / f;
        sb.append(num.get(idx)+"");
        num.remove(idx);
        k = k%f;
        
        helper(num,sb,k,n-1);
    }
    
    private int fact(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return n*fact(n-1);
    }
}