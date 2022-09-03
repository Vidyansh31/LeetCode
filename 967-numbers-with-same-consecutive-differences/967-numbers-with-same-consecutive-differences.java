class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for(int ch = 1; ch <= 9; ch++){
            createNum(ch,k,n-1,ans);
        }
        
        int[] res = new int[ans.size()];
        int i = 0;
        for(int num : ans){
            res[i++] = num;
        }
        return res;
    }
    
    public void createNum(int num, int k, int n, List<Integer> ans){
        if(n == 0){
            if(ans.contains(num)){
                return;
            }
            ans.add(num);
            return;
        }
        
        int digit = num%10;
        
        if(digit + k < 10){
            int newNum = num*10+(digit+k);
            createNum(newNum,k,n-1,ans);
        }
      
        
        if(digit-k >= 0){
            int newNum = num*10+(digit-k);
            createNum(newNum,k,n-1,ans);
        }
        
        
    }
}