class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = Arrays.asList(1,2,3,4,5,6,7,8,9);
        
        for(int i = 2; i <= n; i++){
            List<Integer> curr = new ArrayList<>();
            for(int num : ans){
                int digit = num%10;
                if(digit+k < 10) curr.add(num*10+(digit+k));
                if(k > 0 && digit-k >= 0) curr.add(num*10+(digit-k));
            }
            ans = curr;
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