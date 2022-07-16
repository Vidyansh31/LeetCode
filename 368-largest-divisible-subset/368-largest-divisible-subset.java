class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] hash = new int[n];
        int ans = 1;
        int li = 0;
        
        
        for(int i = 1; i < n; i++){
            hash[i] = i;
            for(int prev = 0; prev < i; prev++){
                if(nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            
            if(dp[i] > ans){
                ans = dp[i];
                li = i;
            }
        }
        
        
        List<Integer> rv = new ArrayList<>();
        rv.add(nums[li]);
        while(li != hash[li]){
            li = hash[li];
            rv.add(0,nums[li]);
        }
        
        
        return rv;
    }
}