class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        int[] dp = new int[1];
        dp[0] = 1;
        
        for(int i = 1; i <= rowIndex ; i++){
            int[] temp = new int[i+1];
            
            for(int j = 0; j < temp.length; j++){
                if(j == 0 || j == temp.length-1) {
                    temp[j] = dp[0];
                }
                else{
                    temp[j] = dp[j-1] + dp[j];
                }
            }
            
            dp = temp;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int num : dp){
            res.add(num);
        }
        
        return res;
    }
}